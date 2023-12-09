package net.mariasoft.administrations.service.structres;

import net.mariasoft.administrations.domain.Structures;
import net.mariasoft.administrations.dtos.StructuresDto;
import net.mariasoft.administrations.mappers.StructuresMapper;
import net.mariasoft.administrations.repository.StructuresRepository;
import net.mariasoft.administrations.utils.OsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import org.springframework.util.StringUtils;

@Service
public class StructureService implements IStructureService {

    private final StructuresRepository structuresRepository;
    private final Logger log = LoggerFactory.getLogger(StructureService.class);
    private final StructuresMapper structuresMapper;

    public StructureService(StructuresRepository structuresRepository, StructuresMapper structuresMapper) {
        this.structuresRepository = structuresRepository;
        this.structuresMapper = structuresMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public StructuresDto creationStructure(StructuresDto structuresDto) {
        log.debug("Attempting to create Structure with info: {}", structuresDto);
        var structures = structuresMapper.toEntity(structuresDto);
        structures = structuresRepository.saveAndFlush(structures);
        log.debug("Structure created successfully with info: {}", structuresDto);
        return structuresMapper.toDto(structures);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public StructuresDto updateStructure(StructuresDto structuresDto) {
        log.debug("Attempting to update Structure with info: {}", structuresDto);
        Structures existingStructure = structuresRepository.findById(structuresDto.id())
                .orElseThrow(() -> {
                    log.error("Failed to find Structure id: {}", structuresDto.id());
                    throw new IllegalArgumentException("Structure with given id not found");
                });
        existingStructure = structuresMapper.partialUpdate(structuresDto, existingStructure);
        existingStructure = structuresRepository.saveAndFlush(existingStructure);
        log.debug("Structure updated successfully with info: {}", structuresDto);
        return structuresMapper.toDto(existingStructure);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void deleteStructure(Long sid) {
        log.debug("Attempting to delete Structure with info: {}", sid);
        Structures existingStructure = structuresRepository.findById(sid)
                .orElseThrow(() -> {
                    log.error("Failed to find Structure id: {}", sid);
                    throw new IllegalArgumentException("Structure with given id not found");
                });
        structuresRepository.delete(existingStructure);
        log.debug("Structure deleted with info: {}", existingStructure);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class, readOnly = true)
    public StructuresDto getStructure(Long sid) {
        log.debug("Attempting to get Structure by id: {}", sid);
        Structures structures = structuresRepository.findById(sid)
                .orElseThrow(() -> {
                    log.error("Failed to find Structure id: {}", sid);
                    return new IllegalArgumentException("Structure with given id not found");
                });
        log.debug("Structure found by id: {}", sid);
        return structuresMapper.toDto(structures);
    }

    /**
     * @param structuresDto
     * @param file          The logo file.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void uploadStructureLogo(StructuresDto structuresDto, MultipartFile file) {
        log.debug("Attempting to upload a logo for structure ID: {}", structuresDto.id());

        Structures existingStructure = validateStructureExists(structuresDto.id());

        Path logoPath = prepareLogoPath(file,structuresDto.id());

        try {
            deleteExistingLogo(logoPath);

            saveLogo(logoPath, file);

            log.debug("Logo uploaded successfully for structure ID: {}", structuresDto.id());
        } catch (IOException e) {
            log.error("Error while uploading logo for structure ID: {}", structuresDto.id(), e);
            throw new RuntimeException("Could not upload logo for structure ID: " + structuresDto.id(), e);
        }
    }

    private Structures validateStructureExists(Long id) {
        return structuresRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Failed to find Structure id: {}", id);
                    return new IllegalArgumentException("Structure with given id not found");
                });
    }

    private Path prepareLogoPath(MultipartFile file, Long id) {
        Path dir = Paths.get(OsUtils.getOsHomeDir()+ "/structure" + id + "/image/logos/");
        if (!Files.exists(dir)) {
            createLogoDirectory(dir);
        }
        return dir.resolve(StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename())));
    }

    private void createLogoDirectory(Path dir) {
        try {
            Files.createDirectories(dir);
            log.debug("Directory 'structures-logo' didn't exist and was created");
        } catch (IOException e) {
            log.error("Error while creating 'structures-logo' directory", e);
            throw new RuntimeException("Could not create directory for the logos", e);
        }
    }

    private void deleteExistingLogo(Path logoPath) throws IOException {
        if (Files.exists(logoPath)) {
            Files.delete(logoPath);
            log.debug("Previous logo has been deleted");
        }
    }

    private void saveLogo(Path logoPath, MultipartFile file) throws IOException {
        Files.copy(file.getInputStream(), logoPath);
    }


}
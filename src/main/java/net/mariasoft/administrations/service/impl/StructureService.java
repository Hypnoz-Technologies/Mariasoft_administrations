package net.mariasoft.administrations.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.mariasoft.administrations.domain.Structures;
import net.mariasoft.administrations.dtos.StructuresDto;
import net.mariasoft.administrations.mappers.StructuresMapper;
import net.mariasoft.administrations.repository.StructuresRepository;
import net.mariasoft.administrations.service.IStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StructureService implements IStructureService {

    private final StructuresRepository structuresRepository;
    private final Logger log = LoggerFactory.getLogger(StructureService.class);
    private final StructuresMapper structuresMapper;

    public StructureService(StructuresRepository structuresRepository, StructuresMapper structuresMapper) {
        this.structuresRepository = structuresRepository;
        this.structuresMapper = structuresMapper;
    }

    /**
     * @param structuresDto
     * @return
     */
    @Override
    public StructuresDto creationStructure(StructuresDto structuresDto) {

        return null;
    }

    /**
     * @param structuresDto
     * @return
     */
    @Override
    public StructuresDto updateStructure(StructuresDto structuresDto) {
        return null;
    }

    /**
     * @param structuresDto
     * @return
     */
    @Override
    public StructuresDto deleteStructure(StructuresDto structuresDto) {
        return null;
    }

    /**
     * @param sid
     * @return StructuresDto
     */
    @Override
    public StructuresDto getStructure(Long sid) {
        log.debug("getStructure {}", sid);
        Structures structures = structuresRepository.findById(sid)
                .orElseThrow();
        return structuresMapper.toDto(structures);
    }

}

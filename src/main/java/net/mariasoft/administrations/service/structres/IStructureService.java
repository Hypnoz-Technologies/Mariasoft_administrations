package net.mariasoft.administrations.service.structres;

import net.mariasoft.administrations.dtos.StructuresDto;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

@Service
public interface IStructureService {
    /**
     * Creates a new structure.
     *
     * @param structuresDto The structure data.
     * @return The created structure.
     */
    StructuresDto creationStructure(StructuresDto structuresDto);

    /**
     * Updates an existing structure.
     *
     * @param structuresDto The structure data.
     * @return The updated structure.
     */
    StructuresDto updateStructure(StructuresDto structuresDto);

    /**
     * Deletes an existing structure.
     *
     * @param sid The structure ID.
     * @return The deleted structure.
     */
    void deleteStructure(Long sid);

    /**
     * Returns a structure by its ID.
     *
     * @param sid The structure ID.
     * @return The requested structure.
     */
    StructuresDto getStructure(Long sid);

    /**
     * Uploads a logo for the structure.
     *
     * @param structuresDto The structure ID.
     * @param file The logo file.
     */
    void uploadStructureLogo(StructuresDto structuresDto, MultipartFile file);
}
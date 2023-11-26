package net.mariasoft.administrations.service;

import net.mariasoft.administrations.dtos.StructuresDto;
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
     * @param structuresDto The structure ID.
     * @return The deleted structure.
     */
    StructuresDto deleteStructure(StructuresDto structuresDto);

    /**
     * Returns a structure by its ID.
     *
     * @param sid The structure ID.
     * @return The requested structure.
     */
    StructuresDto getStructure(Long sid);
}

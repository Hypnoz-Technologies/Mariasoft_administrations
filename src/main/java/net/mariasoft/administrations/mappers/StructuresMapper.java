package net.mariasoft.administrations.mappers;

import net.mariasoft.administrations.domain.Structures;
import net.mariasoft.administrations.dtos.StructuresDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StructuresMapper {

    Structures toEntity(StructuresDto structuresDto);

    StructuresDto toDto(Structures structures);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Structures partialUpdate(StructuresDto structuresDto, @MappingTarget Structures structures);
}
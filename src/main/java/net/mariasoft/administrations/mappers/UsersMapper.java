package net.mariasoft.administrations.mappers;

import net.mariasoft.administrations.domain.Users;
import net.mariasoft.administrations.dtos.UsersDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsersMapper {
    Users toEntity(UsersDto usersDto);

    UsersDto toDto(Users users);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Users partialUpdate(UsersDto usersDto, @MappingTarget Users users);
}
package net.mariasoft.administrations.service.users;

import net.mariasoft.administrations.dtos.StructuresDto;
import net.mariasoft.administrations.dtos.UsersDto;

import java.util.List;
import java.util.Optional;

public interface IUsersServices {
    UsersDto createUsers(UsersDto usersDto) throws Exception;

    UsersDto getUsersById(Long id);

    UsersDto updateUsers(UsersDto usersDto);

    UsersDto deleteUsers(Long id);

    List<UsersDto> getAllUsers(Long sid);

    UsersDto findByLogin(String login);

    UsersDto updatePassword(Long id, UsersDto usersDto,String newpassword);

}
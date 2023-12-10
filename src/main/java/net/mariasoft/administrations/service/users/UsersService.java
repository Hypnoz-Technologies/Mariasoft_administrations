package net.mariasoft.administrations.service.users;

import lombok.RequiredArgsConstructor;
import net.mariasoft.administrations.domain.Users;
import net.mariasoft.administrations.dtos.UsersDto;
import net.mariasoft.administrations.mappers.UsersMapper;
import net.mariasoft.administrations.repository.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UsersService implements IUsersServices{
    private final  UsersMapper usersMapper;
    private final UsersRepository usersRepository;
    /**
     * @param usersDto
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UsersDto createUsers(UsersDto usersDto) throws Exception {
        try {
            Users userEntity = usersMapper.toEntity(usersDto);
            userEntity.setUsrPatronyme(usersDto.getUsrNom() + " " + usersDto.getUsrPrenom());
            Users savedUser = usersRepository.save(userEntity);
            return usersMapper.toDto(savedUser);
        } catch (Exception e) {
            throw new Exception("Failed to create user. Rolling back transaction.", e);
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public UsersDto getUsersById(Long id) {
        return null;
    }

    /**
     * @param usersDto
     * @return
     */
    @Override
    public UsersDto updateUsers(UsersDto usersDto) {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public UsersDto deleteUsers(Long id) {
        return null;
    }

    /**
     * @param sid
     * @return
     */
    @Override
    public List<UsersDto> getAllUsers(Long sid) {
        return null;
    }

    /**
     * @param login
     * @return
     */
    @Override
    public UsersDto findByLogin(String login) {
        return null;
    }

    /**
     * @param id
     * @param usersDto
     * @param newpassword
     * @return
     */
    @Override
    public UsersDto updatePassword(Long id, UsersDto usersDto, String newpassword) {
        return null;
    }
}

package net.mariasoft.administrations.service.users;

import lombok.RequiredArgsConstructor;
import net.mariasoft.administrations.domain.UsersStructures;
import net.mariasoft.administrations.repository.UsersStructuresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.mariasoft.administrations.domain.Structures;
import net.mariasoft.administrations.domain.Users;
import net.mariasoft.administrations.dtos.UsersDto;
import net.mariasoft.administrations.mappers.UsersMapper;
import net.mariasoft.administrations.repository.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for performing operations related to the Users entity.
 */
@Service
@RequiredArgsConstructor
public class UsersService implements IUsersServices{
    private static final Logger log = LoggerFactory.getLogger(UsersService.class);

    private final  UsersMapper usersMapper;
    /**
     *
     */
    private final UsersRepository usersRepository;
    /**
     * Class for accessing the UsersStructures data in the database.
     */
    private final UsersStructuresRepository usersStructuresRepository;

    /**
     * Creates a new user based on the provided UsersDto.
     *
     * @param usersDto The UsersDto object containing the user information.
     * @return The created UsersDto object.
     * @throws Exception If there is an error creating the user.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UsersDto createUsers(UsersDto usersDto) throws Exception {
        log.debug("Enter createUsers");
        try {
            Users userEntity = usersMapper.toEntity(usersDto);
            userEntity.setUsrPatronyme(usersDto.getUsrNom() + " " + usersDto.getUsrPrenom());
            Users savedUser = usersRepository.save(userEntity);
            log.debug("Return from createUsers successful");
            return usersMapper.toDto(savedUser);
        } catch (Exception e) {
            log.error("Failed to create user :", e);
            throw new Exception("Failed to create user. Rolling back transaction.", e);
        }
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id the ID of the user to retrieve
     * @return the user information as a {@link UsersDto} object
     * @throws IllegalArgumentException if no user is found with the given ID
     */
    @Override
    public UsersDto getUsersById(Long id) {
        log.debug("Enter getUsersById");
       return usersRepository.findById(id)
               .map(usersMapper::toDto)
               .orElseThrow(() -> {
            log.error("Failed to find user id: {}", id);
                   return new IllegalArgumentException("User with given id not found");
        });
    }

    /**
     * Updates the users information.
     *
     * @param usersDto the UsersDto object containing the updated user information
     * @return the updated UsersDto object
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UsersDto updateUsers(UsersDto usersDto) {
        log.debug("Enter updateUsers");
        Users existingUser = usersRepository.findById(usersDto.getId()).orElseThrow();
        Users updatedUser = usersMapper.partialUpdate(usersDto, existingUser);
        Users savedUser = usersRepository.save(updatedUser);
        log.debug("Return from updateUsers successful");
        return usersMapper.toDto(savedUser);
    }

    /**
     * Deletes a user with the given id.
     *
     * @param id the id of the user to delete
     * @throws IllegalArgumentException if a user with the given id is not found
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUsers(Long id) {
        log.debug("Enter deleteUsers");
        Users existingStructure = usersRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Failed to find user id: {}", id);
                    throw new IllegalArgumentException("User with given id not found");
                });
        usersRepository.delete(existingStructure);
        log.debug("Return from deleteUsers successful");
    }

    /**
     * Retrieves all users associated with a given SID (Structure ID).
     *
     * @param sid the Structure ID to retrieve users for
     * @return a list of UsersDto objects representing the users associated with the given SID
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<UsersDto> getAllUsers(Long sid) {
        log.debug("Enter getAllUsers");
        return usersStructuresRepository.findByUsersStructuresId_UserId(sid)
                .stream().map(UsersStructures::getUser)
                .map(usersMapper::toDto)
                .toList();
    }

    /**
     * Find a user by their login.
     *
     * @param login the login of the user
     * @return the user DTO matching the login, or null if no user is found
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public UsersDto findByLogin(String login) {
        log.debug("Enter findByLogin");
        return usersRepository.findByUsrLogin(login)
                .map(usersMapper::toDto)
                .orElseThrow(() -> {
                    log.error("Failed to find user Login: {}", login);
                    return new IllegalArgumentException("User with given Login not found");
                });
    }

    /**
     * Updates the password for a user.
     *
     * @param id         The ID of the user.
     * @param usersDto   The UsersDto object containing the user information.
     * @param newpassword The new password to set.
     * @return The updated UsersDto object.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UsersDto updatePassword(Long id, UsersDto usersDto, String newpassword) {
        log.debug("Enter updatePassword");
        return null;
    }
}
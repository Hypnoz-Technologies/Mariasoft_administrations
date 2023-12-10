package net.mariasoft.administrations.repository;

import net.mariasoft.administrations.domain.UsersStructures;
import net.mariasoft.administrations.domain.UsersStructuresId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersStructuresRepository extends JpaRepository<UsersStructures, UsersStructuresId> {
    List<UsersStructures> findByUsersStructuresId_UserId(Long userId);
}
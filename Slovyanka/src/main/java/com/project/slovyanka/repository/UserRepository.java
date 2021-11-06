package com.project.slovyanka.repository;

import com.project.slovyanka.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Illia Koshkin
 * Цей інтерфейс поєднує JpaRepository(інтерфейс, що з'єднується з SQL)
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailUsername(String email);
}

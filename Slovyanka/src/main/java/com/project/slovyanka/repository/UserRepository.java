package com.project.slovyanka.repository;

import com.project.slovyanka.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author Illia Koshkin
 * Цей інтерфейс поєднує JpaRepository(інтерфейс, що з'єднується з SQL)
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailUsername(String email);
    Optional<User> findUserByActivationCode(String activationCode);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE users SET non_locked = 1 WHERE (id = ?1)", nativeQuery = true)
    void unlockAccountById(@Param("id") Integer id);
}

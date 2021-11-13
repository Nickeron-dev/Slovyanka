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
    /**
     * Цей метод шукає користувача за його email
     * @param email пошта користувача
     * @return Optional з User, тобто сутність може бути не знайденою
     */
    Optional<User> findByEmailUsername(String email);

    /**
     * Цей метод шукає користувача за кодом активації
     * @param activationCode код активації акаунту
     * @return Optional з User, тобто сутність може бути не знайденою
     */
    Optional<User> findUserByActivationCode(String activationCode);

    /**
     * Цей метод буде запускати написаний запит(UPDATE users...) у базу даних.
     * Він разблоковує користувача за даним id.
     * @param id ідентифікатор користувача
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE users SET non_locked = 1 WHERE (id = ?1)", nativeQuery = true)
    void unlockAccountById(@Param("id") Integer id);

    /**
     * Цей метод змінює пароль на новий
     * @param id ідентифікатор користувача
     * @param password новий пароль
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE users SET password = ?2 WHERE (id = ?1)", nativeQuery = true)
    void changePasswordById(@Param("id") Integer id, @Param("password") String password);
}

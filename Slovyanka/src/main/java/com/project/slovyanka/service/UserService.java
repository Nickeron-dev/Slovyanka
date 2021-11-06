package com.project.slovyanka.service;

import com.project.slovyanka.dto.UserDTO;
import com.project.slovyanka.entity.User;
import com.project.slovyanka.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    /**
     * Завантажувати користувача через його email буде набагото ефективнішим(ніж через username),
     * бо саме колонка email у базі данних має унікальні значення.
     * @param userEmail
     * @return об'єкт UserDetails
     * @throws UsernameNotFoundException у випадку коли користувача у базі данних не знайдено
     */
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return userRepository.findByEmailUsername(userEmail).orElseThrow(() ->
                new UsernameNotFoundException("User with username: " + userEmail + " not found"));
    }

    /**
     * Цей метод для зберігання нового користувача(під час реєстрації, наприклад)
     * @param user Приймається об'єкт UserDTO, а не User!!! Це для того, щоб не 'тягнути' ще 4 поля(булевські поля класу User
     *             accountNonEpired, accountNonLocked, enabled та credentialsNonExpired), які можна заповнити і вручну.
     * @throws DataIntegrityViolationException У разі, якщо не вийшло додати користувача до бази данних
     */
    public void saveNewUser(UserDTO user) throws DataIntegrityViolationException {
        userRepository.save(User.builder()
                .emailUsername(user.getEmail())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .enabled(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .build());

    }
}

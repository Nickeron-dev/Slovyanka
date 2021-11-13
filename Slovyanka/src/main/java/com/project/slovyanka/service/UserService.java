package com.project.slovyanka.service;

import com.project.slovyanka.configurator.ActivationCodeGenerator;
import com.project.slovyanka.dto.UserDTO;
import com.project.slovyanka.entity.Role;
import com.project.slovyanka.entity.User;
import com.project.slovyanka.repository.UserRepository;
import com.project.slovyanka.view.TextsPaths;
import com.project.slovyanka.view.View;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Illia Koshkin
 * Цей клас є повним підключенням(через нього буде впроваджено взаємодію з веб-застосунком)
 */
@AllArgsConstructor

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    @Autowired
    private SendEmailService sendService;

    /**
     * Завантажувати користувача через його email буде набагато ефективнішим(ніж через username),
     * бо саме колонка email у базі данних має унікальні значення.
     * Також цей метод авторизую відповідного користувача!!!
     * @param userEmail email користувача
     * @return об'єкт UserDetails
     * @throws UsernameNotFoundException у випадку коли користувача у базі даних не знайдено
     */
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return userRepository.findByEmailUsername(userEmail).orElseThrow(() ->
                new UsernameNotFoundException("User with username: " + userEmail + " not found"));
    }

    /**
     * Цей метод для зберігання нового користувача(під час реєстрації, наприклад)
     * @param userDTO Приймається об'єкт UserDTO, а не User!!! Це для того, щоб не 'тягнути' ще 4 поля(булевські поля класу User
     *             accountNonEpired, accountNonLocked, enabled та credentialsNonExpired), які можна заповнити і вручну.
     * @throws DataIntegrityViolationException У разі, якщо не вийшло додати користувача до бази даних
     */
    public void saveNewUser(UserDTO userDTO) throws DataIntegrityViolationException {
        try {
            User user = User.builder()
                    .emailUsername(userDTO.getEmail())
                    .password(userDTO.getPassword())
                    .firstName(userDTO.getFirstName())
                    .lastName(userDTO.getLastName())
                    .role(Role.USER)
                    .activationCode(ActivationCodeGenerator.generate())
                    .enabled(true)
                    .accountNonExpired(true)
                    .accountNonLocked(false)
                    .credentialsNonExpired(true)
                    .build();
            sendService.sendEmail(user.getEmailUsername(), "Welcome to Slavonic Gymnasia!", "To finish registering please go to the following link: http://localhost:8080/activation/" + user.getActivationCode());
            if (ifExistsByEmailUsername(user.getEmailUsername())) {
                throw new DataIntegrityViolationException(View.view.getBundleText(TextsPaths.USER_ALREADY_EXISTS_ERROR));
            } else {
                userRepository.save(user);
            }
        } catch (DataIntegrityViolationException exc) {
            if (exc.getMessage().equals(View.view.getBundleText(TextsPaths.USER_ALREADY_EXISTS_ERROR))) {
                throw new DataIntegrityViolationException(View.view.getBundleText(TextsPaths.USER_ALREADY_EXISTS_ERROR));
            }
        }

    }

    /**
     * Цей метож перевіряє чи вже використовується цей email
     * @param emailUsername строку(String) email.
     * @return Булевське значення, що відповідає на запитання: 'Чи використовується цей email?'
     */
    public boolean ifExistsByEmailUsername(String emailUsername) {
        Optional<User> user = userRepository.findByEmailUsername(emailUsername);
        return user.isPresent();
    }

    /**
     * Цей метод розблокує користувача за активаційним кодом
     * @param code код активації
     * @return булевське значення, що вказує на результат виконання цього методу
     */
    public boolean unlockUserByActivationCode(String code) {
        Optional<User> user = userRepository.findUserByActivationCode(code);
        if (user.isPresent()) {
            userRepository.unlockAccountById(user.get().getId());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Цей метод змінює пароль за ключем
     * @param code ключ активації акаунта, який буде і для відновлення пароля
     * @param password новий пароль
     * @return булевське значення що вказує на результат
     */
    public boolean changePasswordByActivationCode(String code, String password) {
        Optional<User> user = userRepository.findUserByActivationCode(code);
        if (user.isPresent()) {
            userRepository.changePasswordById(user.get().getId(), password);
            System.out.println("Password: " + password);
            System.out.println("Id: " + user.get().getId());
            return true;
        } else {
            System.out.println("User not found");
            return false;
        }
    }

    /**
     * Цей метод дає булевське значення, яке відповідає на питання: чи є користувач за даним кодом активації
     * @param code код активації
     * @return булевське значення результату
     */
    public boolean isUserByActivationCodeExists(String code) {
        return userRepository.findUserByActivationCode(code).isPresent();
    }

    /**
     * Цей метод повертає можливий(через Optional) об'єкт користувача з бази даних за допомогою даного email
     * @param email пошта користувача, якого треба знайти
     * @return Optional з User, бо користувач може бути не знайденим
     */
    public Optional<User> findByEmailUsername(String email) {
        return userRepository.findByEmailUsername(email);
    }

}

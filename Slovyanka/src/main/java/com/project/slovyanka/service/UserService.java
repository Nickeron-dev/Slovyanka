package com.project.slovyanka.service;

import com.project.slovyanka.dto.UserDTO;
import com.project.slovyanka.entity.Role;
import com.project.slovyanka.entity.User;
import com.project.slovyanka.repository.UserRepository;
import com.project.slovyanka.view.TextsPaths;
import com.project.slovyanka.view.View;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Illia Koshkin
 * Цей клас є повним підключенням(через нього буде впроваджено взаємодію з веб-застосунком)
 */
@AllArgsConstructor

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    /**
     * Завантажувати користувача через його email буде набагото ефективнішим(ніж через username),
     * бо саме колонка email у базі данних має унікальні значення.
     * @param userEmail email користувача
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
     * @param userDTO Приймається об'єкт UserDTO, а не User!!! Це для того, щоб не 'тягнути' ще 4 поля(булевські поля класу User
     *             accountNonEpired, accountNonLocked, enabled та credentialsNonExpired), які можна заповнити і вручну.
     * @throws DataIntegrityViolationException У разі, якщо не вийшло додати користувача до бази данних
     */
    public void saveNewUser(UserDTO userDTO) throws DataIntegrityViolationException {
        try {
            User user = User.builder()
                    .emailUsername(userDTO.getEmail())
                    .password(userDTO.getPassword())
                    .firstName(userDTO.getFirstName())
                    .lastName(userDTO.getLastName())
                    .role(Role.USER)
                    .enabled(true)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .build();
            try {
                loadUserByUsername(user.getEmailUsername());
            } catch (UsernameNotFoundException e) {
                userRepository.save(user);
                return;
            }
            throw new DataIntegrityViolationException(View.view.getBundleText(TextsPaths.USER_ALREADY_EXISTS_ERROR));
        } catch (DataIntegrityViolationException exc) {
            if (exc.getMessage().equals(View.view.getBundleText(TextsPaths.USER_ALREADY_EXISTS_ERROR))) {
                throw new DataIntegrityViolationException(View.view.getBundleText(TextsPaths.USER_ALREADY_EXISTS_ERROR));
            }
        }

    }
}

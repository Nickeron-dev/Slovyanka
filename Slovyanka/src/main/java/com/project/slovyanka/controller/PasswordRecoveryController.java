package com.project.slovyanka.controller;

import com.project.slovyanka.entity.User;
import com.project.slovyanka.service.SendEmailService;
import com.project.slovyanka.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

/**
 * @author Illia Koshkin
 * Цей контролер опрацьовує запити на зміну пароля від акаунту
 */
@AllArgsConstructor

@RestController
@RequestMapping("/")
public class PasswordRecoveryController {
    private final UserService userService;
    @Autowired
    private SendEmailService sendService;

    /**
     * Цей метод відкриває головну(першу) сторінку зміни пароля(саме тут треба вводити пошту для повідомлення)
     * @param model об'єкт для інтернаціоналізації
     * @return відкриває відповідну сторінку
     */
    @GetMapping("/password-recovery")
    public ModelAndView enterEmailToRecover(Model model) {
        return new ModelAndView("recoveryRequest");
    }

    /**
     * Цей метод опрацьовує POST-запит(після натискання кнопки вводу пошти) та відправляє повідомлення для зміни пароля
     * @param model об'єкт для інтернаціоналізації
     * @param email пошта користувача(береться з форми)
     * @return відкриває відповідну сторінку
     */
    @PostMapping("/password-recovery")
    public ModelAndView enterEmailToRecoverPost(Model model, @RequestParam(name = "email") String email) {
        Optional<User> foundUser = userService.findByEmailUsername(email);
        foundUser.ifPresent(user -> sendService.sendEmail(email, "Password recovery", "Hello! Go to the following link to change" +
                " your password: http://localhost:8080/password-recovery/" + user.getActivationCode()));

        model.addAttribute("emailSent", "Email with message to change password was sent to inserted email");
        return new ModelAndView("recoveryRequestResult");
    }

    /**
     * Цей метод відкриває сторінку, яка перевіряє посилання для зміни пароля та дає можливість встановити новий
     * @param model об'єкт для інтернаціоналізації
     * @param code код активації(береться з посилання)
     * @return відкриває відповідну сторінку
     */
    @GetMapping("/password-recovery/{code}")
    public ModelAndView recoverPassword(Model model, @PathVariable String code) {
        if (userService.isUserByActivationCodeExists(code)) {
            model.addAttribute("passwordRecoveryResult", "Change your password!");
            model.addAttribute("activationCode", code);
            System.out.println("given code: " + code);
            return new ModelAndView("recovery");
        }
        model.addAttribute("passwordRecoveryResult", "You code doesn't work!!!");
        return new ModelAndView("recovery");
    }

    /**
     * Цей метод опрацьовує останній крок - зміну пароля
     * @param attributes об'єкт для інтернаціоналізації через redirect
     * @param password пароль(береться з форми)
     * @param code код активації(він автоматично заповнюється у формі)
     * @return переадресовує користувача до сторінки входу в акаунт
     */
    @PostMapping("/password-recovery/{code}")
    public RedirectView changePassword(RedirectAttributes attributes, @RequestParam("password") String password, @RequestParam("code") String code) {
        if (userService.changePasswordByActivationCode(code, password)) {
            attributes.addAttribute("passwordRecoveryResult", "Ви успішно змінили пароль!");
        } else {
            attributes.addAttribute("passwordRecoveryResult", "На жаль, пароль не було змінено!");
        }


        return new RedirectView("/login");
    }
}

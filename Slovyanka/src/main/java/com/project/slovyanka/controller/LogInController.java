package com.project.slovyanka.controller;

import com.project.slovyanka.entity.User;
import com.project.slovyanka.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Illia Koshkin
 * Цей контролер опрацьовує всі запити пов'язані з входом в аккаунт
 */
@AllArgsConstructor

@RestController
@RequestMapping("/")
@ResponseBody
public class LogInController {
    private final UserService userService;

    /**
     * Цей метод опрацьовує GET-запит(відкриває сторінку авторизації)
     * @return об'єкт, який може одразу приймати аргументи(для відображення сторінки з обраною мовою)
     */
    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("logIn");
    }

    /**
     * Цей метод опрацьовує POST-запит(опрацьовує ввід від користувача після натискання кнопки 'ввести'
     * @param user об'єкт користувача(який імплементує інтерфейс UserDetails) для того, щоб взяти email, який є username
     * @return об'єкт, який може одразу приймати аргументи(для відображення сторінки з обраною мовою)
     */
    @PostMapping("/login")
    public ModelAndView login(User user) {
        userService.loadUserByUsername(user.getEmailUsername());
        return new ModelAndView("logInResult");
    }
}

package com.project.slovyanka.controller;

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

    /**
     * Цей метод опрацьовує GET-запит(відкриває сторінку авторизації)
     * @param passwordRecoveryResult аргумент, що МОЖЛИВО буде, коли користувач переадресований після зміни пароля
     * @return об'єкт, який може одразу приймати аргументи(для відображення сторінки з обраною мовою)
     */
    @GetMapping("/login")
    public ModelAndView loginPage(@ModelAttribute("passwordRecoveryResult") final String passwordRecoveryResult) {
        ModelAndView modelAndView = new ModelAndView("logIn");
        modelAndView.getModel().put("passwordRecoveryResult", passwordRecoveryResult);
        return modelAndView;
    }

    /**
     * Цей метод опрацьовує POST-запит(опрацьовує ввід від користувача після натискання кнопки 'ввести'
     * @return об'єкт, який може одразу приймати аргументи(для відображення сторінки з обраною мовою)
     */
    @PostMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("logInResult");
    }
}

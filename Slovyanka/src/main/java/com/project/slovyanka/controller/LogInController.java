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
     * @return об'єкт, який може одразу приймати аргументи(для відображення сторінки з обраною мовою)
     */
    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("logIn");
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

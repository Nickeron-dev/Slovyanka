package com.project.slovyanka.controller;

import com.project.slovyanka.dto.UserDTO;
import com.project.slovyanka.service.UserService;
import com.project.slovyanka.view.TextsPaths;
import com.project.slovyanka.view.View;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Illia Koshkin
 * Цей клас є реєстраційним контролером, він опрацьовує всі запити(методів GET та POST), які пов'язані з реєстрацією
 * у веб-застосунку.
 */
@AllArgsConstructor

@RestController
@RequestMapping("/")
public class RegistrationController {
    private final UserService userService;

    /**
     * Цей метод відкриває реєстраційну сторінку.
     * Використовується ModelAndView, бо це @RestController, а не @Controller. Головна ідея була - притримуватися
     * принципу SRP(Single Responsibility Principle) з SOLID. Але декілька @Controller не може бути у веб-застосунку.
     * Отже, треба використовувати @RestController, який може коректно працювати з ModelAndView.
     * @return ModelAndView об'єкт з відповідною сторінкою.
     */
    @GetMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("registration");
    }

    /**
     * Цей метод відповідає за POST запит у реєстраційній формі.
     * @param model цей об'єкт дає можливість передавати значення з backend(Java) до frontend(HTML)
     * @param email приймає параметр "email" з POST запиту
     * @param password приймає параметр "password" з POST запиту
     * @param firstName приймає параметр "firstName" з POST запиту
     * @param lastName приймає параметр "lastName" з POST запиту
     * @return ModelAndView об'єкт з відповідною сторінкою.
     */
    @PostMapping("/register")
    public ModelAndView result(Model model, @RequestParam("email") String email, @RequestParam("password") String password,
                         @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        System.out.println("Email: " + email);
        System.out.println("password: " + password);
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);
        UserDTO newUser = UserDTO.builder()
                .email(email)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .build();
        try {
            System.out.println("Trying!!!");
            userService.saveNewUser(newUser);
        } catch (DataIntegrityViolationException exc) {
            // here should be logger
            if (exc.getMessage().equals(View.view.getBundleText(TextsPaths.USER_ALREADY_EXISTS_ERROR))) {
                model.addAttribute("resultMessage", View.view.getBundleText(TextsPaths.USER_ALREADY_EXISTS_ERROR));
                return new ModelAndView("registrationResult");
            }
            model.addAttribute("resultMessage", "You haven't registered!!!");
            return new ModelAndView("registrationResult");
        }
        model.addAttribute("resultMessage", "You have successfully!!!");
        return new ModelAndView("registrationResult");
    }
}

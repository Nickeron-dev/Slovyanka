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

@AllArgsConstructor

@RestController
@RequestMapping("/")
public class RegistrationController {
    private final UserService userService;

    @GetMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("registration");
    }

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

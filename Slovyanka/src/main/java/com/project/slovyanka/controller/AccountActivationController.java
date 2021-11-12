package com.project.slovyanka.controller;

import com.project.slovyanka.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Illia Koshkin
 * Цей контролер активує користувача при переході за посиланням, яке прийшло на пошту.
 */
@AllArgsConstructor

@RestController
@RequestMapping("/")
public class AccountActivationController {
    private final UserService userService;

    /**
     * Цей метод опрацьовує запити на активацію
     * @param model об'єкт що може містити повідомлення, відповідно до мови
     * @param code активаційний ключ з посилання, яке отримує користувач на пошту
     * @return переадресація до сторінки входу до акаунту користувача.
     */
    @GetMapping("/activation/{code}")
    public RedirectView activateAccount(Model model, @PathVariable String code) {
        if (userService.unlockUserByActivationCode(code)) {
            model.addAttribute("activationResult", "You've successfully activated account!");
            System.out.println("given code: " + code);
            return new RedirectView("/login");
        }
        model.addAttribute("activationResult", "You code doesn't work!!!");
        return new RedirectView("/login");
    }
}

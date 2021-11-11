package com.project.slovyanka.controller;

import com.project.slovyanka.configurator.EmailConfigurator;
import com.project.slovyanka.service.SendEmailService;
import com.project.slovyanka.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@AllArgsConstructor

@RestController
@RequestMapping("/")
public class AccountActivationController {
    private final UserService userService;

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

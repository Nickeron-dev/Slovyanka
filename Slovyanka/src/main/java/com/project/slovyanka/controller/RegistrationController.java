package com.project.slovyanka.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class RegistrationController {
    @GetMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("registration");
    }

    @PostMapping("/register")
    public String result(@RequestParam(value = "email", required = false) String email) {
        System.out.println("Hello");
        System.out.println(email);
        return "Hello";
    }
}

package com.project.slovyanka.controller;

import com.project.slovyanka.dto.UserDTO;
import com.project.slovyanka.entity.User;
import com.project.slovyanka.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@AllArgsConstructor

@RestController
@RequestMapping("/")
@ResponseBody
public class LogInController {
    private final UserService userService;

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("logIn");
    }

//    @PostMapping("/login")
//    public ModelAndView loginResult(Model model, @RequestParam("email") String email, @RequestParam("password") String password) {
//        if (userService.ifEmailAndPasswordCorrect(email, password)) {
//            userService.loadUserByUsername(email);
//            model.addAttribute("logInResult", "You've logged in!!!");
//            System.out.println(Arrays.toString(SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().toArray()));
//            System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//        } else {
//            model.addAttribute("logInResult", "Email and password are incorrect!!!");
//            System.out.println(Arrays.toString(SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().toArray()));
//            model.addAttribute("auth", SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
//        }
//        return new ModelAndView("/logInResult");
//    }

    @PostMapping("/login")
    @ResponseBody
    public ModelAndView loginResult(Model model, @RequestParam("email") String email, @RequestParam("password") String password) {
        System.out.println("Hello1");
        if (userService.ifEmailAndPasswordCorrect(email, password)) {
            System.out.println("Hello2");
            userService.loadUserByUsername(email);
            model.addAttribute("logInResult", "You've logged in!!!");
            System.out.println(Arrays.toString(SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().toArray()));
            System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        } else {
            System.out.println("Hello3");
            model.addAttribute("logInResult", "Email and password are incorrect!!!");
            System.out.println(Arrays.toString(SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().toArray()));
            model.addAttribute("auth", SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
        }
        return new ModelAndView("/logInResult");
    }

//    @PostMapping("/login")
//    @ResponseBody
//    public ModelAndView loginResult(Model model, UserDTO user) throws UsernameNotFoundException {
//        userService.loadUserByUsername(user.getEmail());
//        System.out.println("Email: " + user.getEmail());
//        System.out.println("Pass: " + user.getPassword());
//        System.out.println("First name: " + user.getFirstName());
//        System.out.println("last name: " + user.getLastName());
//        model.addAttribute("logInResult", "Some Rsult");
//        model.addAttribute("auth", Arrays.toString(SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().toArray()));
//        return new ModelAndView("/logInResult");
//    }
}

package com.project.slovyanka.controller;

import com.project.slovyanka.view.LocaleNames;
import com.project.slovyanka.view.TextsPaths;
import com.project.slovyanka.view.View;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Locale;
import java.util.Optional;

@AllArgsConstructor

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("login", View.view.getBundleText(TextsPaths.HEADER_LOGIN));
        return "index";
    }

    @GetMapping(value = "/change-language", params = "ukr")
    public RedirectView changeLanguageToUkr() {
        View.view.changeLocale(Optional.of(new Locale(LocaleNames.UKR_LANGUAGE)));
        return new RedirectView("/");
    }

    @GetMapping(value = "/change-language", params = "eng")
    public RedirectView changeLanguageToEng() {
        View.view.changeLocale(Optional.of(new Locale(LocaleNames.ENG_LANGUAGE)));
        return new RedirectView("/");
    }

}

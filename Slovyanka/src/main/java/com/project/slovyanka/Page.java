package com.project.slovyanka;

import org.springframework.web.bind.annotation.GetMapping;

public class Page {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}

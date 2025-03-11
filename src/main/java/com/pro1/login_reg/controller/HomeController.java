package com.pro1.login_reg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "home"; // This will look for home.html in src/main/resources/templates/
    }
}
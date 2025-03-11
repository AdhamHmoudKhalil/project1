package com.pro1.login_reg.controller;

import com.pro1.login_reg.model.User;
import com.pro1.login_reg.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        if (userRepo.existsById(user.getUsername())) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }

        userRepo.save(user);
        return "redirect:/login";
    }
}
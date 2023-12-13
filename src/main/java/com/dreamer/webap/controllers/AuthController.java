package com.dreamer.webap.controllers;

import com.dreamer.webap.models.Users;
import com.dreamer.webap.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/auth/login")
    public String log(Model model) {
        model.addAttribute("title", "Authorization");
        return "auth-log-page";
    }

    @PostMapping("/auth/login")
    public String logIn(Users user, Model model) {
        Users foundUser = userRepo.findByUsername(user.getUsername());

        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return "redirect:/";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "auth-log-page";
        }
    }

    @GetMapping("/auth/register")
    public String reg(Model model) {
        model.addAttribute("title", "Registration");
        return "auth-reg-page";
    }

    @PostMapping("/auth/register")
    public String register(Users user, Model model) {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "The username is busy or the data is incorrect");
            return "auth-reg-page";
        }
        userRepo.save(user);
        return "redirect:/auth/login";
    }
}

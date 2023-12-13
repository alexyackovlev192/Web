package com.dreamer.webap.controllers;

import com.dreamer.webap.models.Users;
import com.dreamer.webap.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {
    private final UserRepo repoUser;

    @Autowired
    public UsersController(UserRepo repoUser) {
        this.repoUser = repoUser;
    }

    @GetMapping("/users")
    public String users(Model model) {
        Iterable<Users> users = repoUser.findAll();
        model.addAttribute("users", users);
        return "users-page";
    }
}

package com.example.twitterapp.controller;

import com.example.twitterapp.model.User;
import com.example.twitterapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    private final UserService userService;

    // Constructor injection for UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Show login page
    @GetMapping("/login")
    public String login(Model model, User userDto) {
        model.addAttribute("user", userDto);
        return "login";
    }

    // Show registration page
    @GetMapping("/register")
    public String register(Model model, User userDto) {
        model.addAttribute("user", userDto);
        return "register";
    }

    // Handle user registration
    @PostMapping("/register")
    public String registerSave(@ModelAttribute("user") User userDto, Model model) {
        User user = userService.findByUsername(userDto.getUsername());
        if (user != null) {
            model.addAttribute("Userexist", user); // User already exists
            return "register";
        }
        userService.save(userDto); // Save new user
        return "redirect:/register?success";
    }
}

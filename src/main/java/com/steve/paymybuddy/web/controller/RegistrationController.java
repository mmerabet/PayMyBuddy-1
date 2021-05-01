package com.steve.paymybuddy.web.controller;

import com.steve.paymybuddy.dto.UserDto;
import com.steve.paymybuddy.dto.UserRegistrationDto;
import com.steve.paymybuddy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    final private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    // Pour le log4J
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
        userService.save(userRegistrationDto);
        return "redirect:/registration?success";
    }
}

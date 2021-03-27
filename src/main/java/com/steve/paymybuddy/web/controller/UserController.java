package com.steve.paymybuddy.web.controller;

import com.steve.paymybuddy.dto.UserDto;
import com.steve.paymybuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // Pour le log4J
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping(value = "/Users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> users() {
        return userService.findAll();
    }

    @GetMapping(value = "/UsersCount")
    @ResponseStatus(HttpStatus.OK)
    public long countUsers() {
        return userService.countUsers();
    }

    @GetMapping(value = "/Users/{email}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> user(@PathVariable String email) {
        return userService.userByEmail(email);
    }
}

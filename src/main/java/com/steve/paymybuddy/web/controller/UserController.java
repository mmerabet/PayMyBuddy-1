package com.steve.paymybuddy.web.controller;

import com.steve.paymybuddy.dto.UserDto;
import com.steve.paymybuddy.model.User;
import com.steve.paymybuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // Pour le log4J
    private final Logger logger = Logger.getLogger(this.getClass().getName());


    @PostMapping(value = "/userAdd", produces = "application/json")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto userAdd) throws Exception {
        logger.info("CreatePerson : appel du controller");
        userService.createUser(userAdd);
        return new ResponseEntity(userAdd, HttpStatus.CREATED);
    }

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
    public UserDto user(@PathVariable String email) {
        return userService.userByEmail(email);
    }
}

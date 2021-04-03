package com.steve.paymybuddy.web.controller;

import com.steve.paymybuddy.dto.UserDto;
import com.steve.paymybuddy.dto.UserSaveDto;
import com.steve.paymybuddy.model.User;
import com.steve.paymybuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    public ResponseEntity<User> createUser(@RequestBody @Valid UserSaveDto userAdd) throws Exception {
        logger.info("CreateUser : appel du controller");
        userService.createUser(userAdd);
        return new ResponseEntity(userAdd, HttpStatus.CREATED);
    }

    @PutMapping(value ="/User")
    public ResponseEntity<User>updateUser(@RequestBody @Valid UserSaveDto updateUser) throws Exception{
        logger.info("UpdateUser : appel du controller");
        userService.updateUser(updateUser);
        return new ResponseEntity(updateUser, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value ="/User")
    public ResponseEntity<User>deleteUser(@RequestBody @Valid UserSaveDto deleteUser) throws Exception {
        logger.info("deleteUser : appel du controller");
        userService.deleteUser(deleteUser);
        return new ResponseEntity(deleteUser, HttpStatus.RESET_CONTENT);
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

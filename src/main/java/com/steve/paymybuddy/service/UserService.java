package com.steve.paymybuddy.service;

import com.steve.paymybuddy.dto.UserDto;
import com.steve.paymybuddy.model.User;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

}

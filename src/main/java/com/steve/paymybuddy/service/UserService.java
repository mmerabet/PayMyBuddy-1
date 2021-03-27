package com.steve.paymybuddy.service;

import com.steve.paymybuddy.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
}

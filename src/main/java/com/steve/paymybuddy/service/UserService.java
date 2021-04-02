package com.steve.paymybuddy.service;

import com.steve.paymybuddy.dto.UserDto;
import com.steve.paymybuddy.dto.UserSaveDto;
import com.steve.paymybuddy.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> findAll();

    long countUsers();

    UserDto userByEmail(String email);

    Optional<User> userById(Integer id);

    boolean createUser(UserSaveDto user) throws Exception;

    boolean updateUser(UserSaveDto updateUser);

    boolean deleteUser(UserSaveDto deleteUser);
}

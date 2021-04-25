package com.steve.paymybuddy.service;

import com.steve.paymybuddy.dto.UserDto;
import com.steve.paymybuddy.dto.UserSaveDto;
import com.steve.paymybuddy.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    List<UserDto> findAll();

    long countUsers();

    UserDto userByEmail(String email);

    Optional<User> userById(Integer id);

    boolean createUser(UserSaveDto user) throws Exception;

    boolean updateUser(UserSaveDto updateUser);

    boolean deleteUser(UserSaveDto deleteUser);

    boolean addBuddy(UserSaveDto addBuddy ,Integer idOwner);

    boolean connectUser(UserSaveDto connectUser);
}

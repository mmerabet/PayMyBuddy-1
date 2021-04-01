package com.steve.paymybuddy.service.impl;

import com.steve.paymybuddy.adapter.UserAdapter;
import com.steve.paymybuddy.dao.UserDao;
import com.steve.paymybuddy.dto.UserDto;
import com.steve.paymybuddy.model.User;
import com.steve.paymybuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final UserAdapter userAdapter;

    @Autowired
    public UserServiceImpl(UserDao userDao, UserAdapter userAdapter) {
        this.userDao = userDao;
        this.userAdapter = userAdapter;
    }

    @Override
    public List<UserDto> findAll() {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> users = userDao.findAll();

        for (User user : users) {
            userDtos.add(userAdapter.toDto(user));
        }
        return userDtos;
    }

    @Override
    public long countUsers() {
        return userDao.count();
    }

    @Override
    public UserDto userByEmail(String email) {
        User user = userDao.findByEmail(email);
        UserDto userDto = userAdapter.toDto(user);
        return userDto;
    }

    @Override
    public Optional<User> userById(Integer id) {
        Optional<User> userId = userDao.findById(id);
        return userId;
    }
}

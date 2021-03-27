package com.steve.paymybuddy.service.impl;

import com.steve.paymybuddy.dao.UserDao;
import com.steve.paymybuddy.dto.UserDto;
import com.steve.paymybuddy.model.User;
import com.steve.paymybuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<UserDto> findAll() {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> users = userDao.findAll();

        for (User user : users) {
            UserDto userDto = new UserDto();
            userDto.setFirstName(user.getFirstName());
            userDto.setLastname(user.getLastName());
            userDto.setEmail(user.getEmail());
            userDtos.add(userDto);
        }

        return userDtos;
    }
}

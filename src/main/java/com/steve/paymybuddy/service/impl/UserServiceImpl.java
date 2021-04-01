package com.steve.paymybuddy.service.impl;

import com.steve.paymybuddy.adapter.UserAdapter;
import com.steve.paymybuddy.dao.UserDao;
import com.steve.paymybuddy.dto.UserDto;
import com.steve.paymybuddy.model.User;
import com.steve.paymybuddy.service.UserService;
import com.steve.paymybuddy.web.exception.DataAlreadyExistException;
import com.steve.paymybuddy.web.exception.DataMissingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final UserAdapter userAdapter;

    static Logger logger = LogManager.getLogger(UserServiceImpl.class);

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

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
        System.out.println(userDtos);
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

    @Override
    public boolean createUser(UserDto userAdd) throws Exception {
        Date date = new Date();
        System.out.println("email présent");
        User user = new User();


//            userDao.save(user);
        //je verifie que les informations ne sont pas manquantes

        if (userAdd.getFirstName().isEmpty()) {
            logger.error("Problem");
            throw new DataMissingException("firstName missing!!");

        }
        if (userAdd.getLastname().isEmpty()) {

            logger.error("Problem");
            throw new DataMissingException("lastname missing!!");

        }
        if (userAdd.getPassword().isEmpty()) {
            logger.error("Problem");
            throw new DataMissingException("password missing!!");
        }
        if (userAdd.getEmail().isEmpty()) {
            logger.error("Problem");
            throw new DataMissingException("Email missing!!");
        }

        // je verifie que l'adresse email n'est pas déja dans la base de donnée

        if (userDao.existsByEmail(userAdd.getEmail())) {

            throw new DataAlreadyExistException("Email déja existant!!" + userAdd.getEmail());
        }
        user.setEmail(userAdd.getEmail());
        user.setFirstName(userAdd.getFirstName());
        user.setLastName(userAdd.getLastname());
        user.setPassword(encoder.encode(userAdd.getPassword()));
        user.setBalance(new BigDecimal(0));
        user.setCreateDate(date);
        userDao.save(user);

        System.out.println("ajout user");
        return true;
    }
}

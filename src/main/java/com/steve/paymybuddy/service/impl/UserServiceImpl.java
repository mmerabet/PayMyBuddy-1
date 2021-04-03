package com.steve.paymybuddy.service.impl;

import com.steve.paymybuddy.adapter.UserAdapter;
import com.steve.paymybuddy.dao.UserDao;
import com.steve.paymybuddy.dto.UserDto;
import com.steve.paymybuddy.dto.UserSaveDto;
import com.steve.paymybuddy.model.User;
import com.steve.paymybuddy.service.UserService;
import com.steve.paymybuddy.web.exception.DataAlreadyExistException;
import com.steve.paymybuddy.web.exception.DataMissingException;
import com.steve.paymybuddy.web.exception.DataNotExistException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@EnableTransactionManagement
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final UserAdapter userAdapter;

    static Logger logger = LogManager.getLogger(UserServiceImpl.class);


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
    public boolean createUser(UserSaveDto userAdd) throws Exception {


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
            logger.error("Problem");
            throw new DataAlreadyExistException("Email déja existant!!" + userAdd.getEmail());
        }

        // je set mon model
        User saveUser = userAdapter.toModel(userAdd);

        //je sauvegarde l'user dans la base
        userDao.save(saveUser);
        System.out.println("ajout user");
        return true;
    }

    @Override
    public boolean updateUser(UserSaveDto updateUser) {
        if (!userDao.existsByEmail(updateUser.getEmail())) {
            logger.error("Problem");
            throw new DataNotExistException("Email n'étant pas dans la base!!" + updateUser.getEmail());
        }
        User user = userDao.findByEmail(updateUser.getEmail());
        System.out.println(user);

        // je set mon model
        userAdapter.updateToModel(updateUser, user);
        System.out.println(user);
        userDao.save(user);
        System.out.println("ajout user");
        return true;
    }

    @Override
    public boolean deleteUser(UserSaveDto deleteUser) {
        if (!userDao.existsByEmail(deleteUser.getEmail())) {
            logger.error("Problem");
            throw new DataNotExistException("Email n'étant pas dans la base!!" + deleteUser.getEmail());
        }
            userDao.removeByEmail(deleteUser.getEmail());
        return true;
    }
}

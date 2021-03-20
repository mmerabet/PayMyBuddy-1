package com.steve.paymybuddy.dao;

import com.steve.paymybuddy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

}

package com.steve.paymybuddy.dao;

import com.steve.paymybuddy.model.Relation;
import com.steve.paymybuddy.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {
}

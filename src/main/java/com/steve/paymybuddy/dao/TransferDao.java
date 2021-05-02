package com.steve.paymybuddy.dao;

import com.steve.paymybuddy.model.InternalTransfer;
import com.steve.paymybuddy.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferDao extends JpaRepository<Transfer, Integer> {
}

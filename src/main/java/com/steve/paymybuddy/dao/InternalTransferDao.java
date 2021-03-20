package com.steve.paymybuddy.dao;

import com.steve.paymybuddy.model.InternalTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternalTransferDao extends JpaRepository<InternalTransfer, Integer> {
}

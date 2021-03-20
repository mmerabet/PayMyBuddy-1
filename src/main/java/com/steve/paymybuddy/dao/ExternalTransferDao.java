package com.steve.paymybuddy.dao;

import com.steve.paymybuddy.model.ExternalTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExternalTransferDao extends JpaRepository<ExternalTransfer, Integer> {
}

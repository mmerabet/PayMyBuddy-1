package com.steve.paymybuddy.dao;

import com.steve.paymybuddy.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountDao extends JpaRepository<BankAccount, String> {
    BankAccount findBankAccountByIban(String iban);
}

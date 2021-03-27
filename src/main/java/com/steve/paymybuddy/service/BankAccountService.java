package com.steve.paymybuddy.service;

import com.steve.paymybuddy.dto.BankAccountDto;

import java.util.List;

public interface BankAccountService {
    List<BankAccountDto> findAll();
}

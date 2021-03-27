package com.steve.paymybuddy.web.controller;

import com.steve.paymybuddy.dto.BankAccountDto;
import com.steve.paymybuddy.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class BankAccountController {

    @Autowired
    BankAccountService bankAccountService;

    // Pour le log4J
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping(value = "/BankAccount")
    @ResponseStatus(HttpStatus.OK)
    public List<BankAccountDto> bankAccount() {
        return bankAccountService.findAll();
    }

}

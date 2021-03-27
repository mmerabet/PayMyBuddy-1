package com.steve.paymybuddy.service.impl;

import com.steve.paymybuddy.dao.BankAccountDao;
import com.steve.paymybuddy.dto.BankAccountDto;
import com.steve.paymybuddy.model.BankAccount;
import com.steve.paymybuddy.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    BankAccountDao bankAccountDao;

    @Override
    public List<BankAccountDto> findAll() {

        List<BankAccountDto> bankAccountDtos = new ArrayList<>();
        List<BankAccount> bankAccountDaos = bankAccountDao.findAll();

        for (BankAccount bankAccount : bankAccountDaos) {

            BankAccountDto bankAccountDto = new BankAccountDto();
            bankAccountDto.setAccountName(bankAccount.getAccountName());
            bankAccountDto.setBankName(bankAccount.getBankName());
            bankAccountDto.setIban(bankAccount.getIban());
            bankAccountDto.setBic(bankAccount.getBic());
            bankAccountDtos.add(bankAccountDto);
        }
        return bankAccountDtos;
    }
}

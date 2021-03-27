package com.steve.paymybuddy.service.impl;

import com.steve.paymybuddy.dao.BankAccountDao;
import com.steve.paymybuddy.dto.BankAccountDto;
import com.steve.paymybuddy.model.BankAccount;
import com.steve.paymybuddy.service.BankAccountService;
import com.steve.paymybuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {


    public BankAccountServiceImpl(UserService userService) {
    }

    @Autowired
    BankAccountDao bankAccountDao;

    @Autowired
    UserService userService;


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

    @Override
    public long countBankAccount() {
        long countBankAccount = findAll().size();
        return countBankAccount;
    }

    @Override
    public BankAccountDto bankAccountByEmail(String email) {

//    userService.userByEmail(email).getBankAccounts()
        return null;
    }

    public BankAccountDto getBankAccountUserById(Integer id) {
        // FIXME : simplifier la methhode pour quelle n'utilise plus findAll
        return findAll().stream().filter(bankAccountDto -> bankAccountDto.getUserDto().getId().equals(id)).findFirst().orElse(null);
    }
}

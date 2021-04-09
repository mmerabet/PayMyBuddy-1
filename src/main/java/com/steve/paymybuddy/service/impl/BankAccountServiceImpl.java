package com.steve.paymybuddy.service.impl;

import com.steve.paymybuddy.adapter.BankAccountAdpater;
import com.steve.paymybuddy.dao.BankAccountDao;
import com.steve.paymybuddy.dto.BankAccountDto;
import com.steve.paymybuddy.dto.UserDto;
import com.steve.paymybuddy.model.BankAccount;
import com.steve.paymybuddy.service.BankAccountService;
import com.steve.paymybuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountAdpater bankAccountAdapter;

    private final BankAccountDao bankAccountDao;

    private final UserService userService;

    @Autowired
    public BankAccountServiceImpl(BankAccountDao bankAccountDao, UserService userService, BankAccountAdpater bankAccountAdpater) {
        this.bankAccountDao = bankAccountDao;
        this.userService = userService;
        this.bankAccountAdapter =  bankAccountAdpater;
    }



    @Override
    public List<BankAccountDto> findAll() {

        List<BankAccountDto> bankAccountDtos = new ArrayList<>();
        List<BankAccount> bankAccountDaos = bankAccountDao.findAll();

        for (BankAccount bankAccount : bankAccountDaos) {
           BankAccountDto bankAccountDto = bankAccountAdapter.toDto(bankAccount);
            bankAccountDtos.add(bankAccountDto);
        }
        return bankAccountDtos;
    }

    @Override
    public long countBankAccount() {
      return bankAccountDao.count();
    }

    @Override
    public BankAccountDto bankAccountByEmail(String email) {
        UserDto userDto = userService.userByEmail(email);
        if (userDto != null) {
            List<BankAccountDto> bankAccounts = userDto.getBankAccounts();
            if (!CollectionUtils.isEmpty(bankAccounts)) {
                return bankAccounts.get(0);
            }
        }
        return null;
    }

    public BankAccountDto getBankAccountUserById(Integer id) {
        // FIXME : simplifier la methhode pour quelle n'utilise plus findAll
        return findAll().stream().filter(bankAccountDto -> bankAccountDto.getUserDto().getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public BankAccountDto findBankAccountByIban(String iban) {
       return bankAccountAdapter.toDto(bankAccountDao.findBankAccountByIban(iban));
    }
}

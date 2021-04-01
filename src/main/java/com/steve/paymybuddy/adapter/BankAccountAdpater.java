package com.steve.paymybuddy.adapter;

import com.steve.paymybuddy.dto.BankAccountDto;
import com.steve.paymybuddy.model.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class BankAccountAdpater {

    public BankAccountDto toDto(BankAccount model){
        BankAccountDto dto = new BankAccountDto();

        dto.setAccountName(model.getAccountName());
        dto.setBankName(model.getBankName());
        dto.setIban(model.getIban());
        dto.setBic(model.getBic());
//        dto.getUserDto(model)
        return dto;
    }
}

package com.steve.paymybuddy.adapter;

import com.steve.paymybuddy.dto.BankAccountDto;
import com.steve.paymybuddy.dto.UserDto;
import com.steve.paymybuddy.model.BankAccount;
import com.steve.paymybuddy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserAdapter {

    private final BankAccountAdpater bankAccountAdpater;

    @Autowired
    public UserAdapter(BankAccountAdpater bankAccountAdpater) {
        this.bankAccountAdpater = bankAccountAdpater;
    }

    public UserDto toDto(User model) {

        UserDto dto = new UserDto();
        dto.setId(model.getId());
        dto.setFirstName(model.getFirstName());
        dto.setLastname(model.getLastName());
        dto.setEmail(model.getEmail());
        List<BankAccount> bankAccounts = model.getBankAccounts();
        List<BankAccountDto> bankAccountDtos = new ArrayList<>();

        if (!CollectionUtils.isEmpty(bankAccounts)){
            for (BankAccount bankAccount : bankAccounts) {
                bankAccountDtos.add(bankAccountAdpater.toDto(bankAccount));
            }
        }
        dto.setBankAccounts(bankAccountDtos);
        return dto;
    }
}

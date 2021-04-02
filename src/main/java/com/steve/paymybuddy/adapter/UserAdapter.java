package com.steve.paymybuddy.adapter;

import com.steve.paymybuddy.dto.BankAccountDto;
import com.steve.paymybuddy.dto.UserDto;
import com.steve.paymybuddy.dto.UserSaveDto;
import com.steve.paymybuddy.model.BankAccount;
import com.steve.paymybuddy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserAdapter {

    private final BankAccountAdpater bankAccountAdpater;

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    @Autowired
    public UserAdapter(BankAccountAdpater bankAccountAdpater) {
        this.bankAccountAdpater = bankAccountAdpater;
    }

    Date date = new Date();


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
    public User toModel(UserSaveDto dto){
        User user = new User();
        return getUser(dto, user);
    }
    public User updateToModel(UserSaveDto dto, User user){
        return getUser(dto, user);
    }

    private User getUser(UserSaveDto dto, User user) {
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastname());
        user.setEmail(dto.getEmail());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setCreateDate(date);
        user.setBalance(new BigDecimal(0));
        return user;
    }
}

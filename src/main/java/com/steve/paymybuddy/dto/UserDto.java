package com.steve.paymybuddy.dto;


import com.steve.paymybuddy.model.BankAccount;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UserDto {
    private Integer id;
    private String firstName;
    private String lastname;
    private List<BankAccount> bankAccounts;

    @Email
    @NotNull
    private String email;

    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastname, @Email @NotNull String email, List<BankAccount> bankAccounts) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
        this.bankAccounts = bankAccounts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", bankAccounts=" + bankAccounts +
                ", email='" + email + '\'' +
                '}';
    }
}

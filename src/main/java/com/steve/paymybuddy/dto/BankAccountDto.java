package com.steve.paymybuddy.dto;


import javax.validation.constraints.NotNull;

public class BankAccountDto {

    @NotNull
    private String iban;
    private String bic;
    private String bankName;
    private String accountName;
    private UserDto userDto;

    public BankAccountDto() {
    }

    public BankAccountDto(@NotNull String iban, String bic, String bankName, String accountName, UserDto userDto) {
        this.iban = iban;
        this.bic = bic;
        this.bankName = bankName;
        this.accountName = accountName;
        this.userDto = userDto;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public String toString() {
        return "BankAccountDto{" +
                "iban='" + iban + '\'' +
                ", bic='" + bic + '\'' +
                ", bankName='" + bankName + '\'' +
                ", accountName='" + accountName + '\'' +
                ", userDto=" + userDto +
                '}';
    }
}

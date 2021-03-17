package com.steve.paymybuddy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="bank_account" )
public class BankAccount {
    @Id
    @Column(name = "iban")
    private String iban;
    @Column(name = "bic")
    private String bic;
    @Column(name = "bankName")
    private String bankName;
    @Column(name = "accountName")
    private String accountName;
    @Column(name = "user_iD")
    private int userID;

    public BankAccount() {
    }

    public BankAccount(String iban, String bic, String bankName, String accountName, int userID) {
        this.iban = iban;
        this.bic = bic;
        this.bankName = bankName;
        this.accountName = accountName;
        this.userID = userID;
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "iban='" + iban + '\'' +
                ", bic='" + bic + '\'' +
                ", bankName='" + bankName + '\'' +
                ", accountName='" + accountName + '\'' +
                ", userID=" + userID +
                '}';
    }
}

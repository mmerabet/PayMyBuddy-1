package com.steve.paymybuddy.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "external_transfer")
@PrimaryKeyJoinColumn(name = "transfer_id") // PK de l'entité mere
public class ExternalTransfer extends Transfer{

    @Column(name = "fees")
    private BigDecimal fees;

    @ManyToOne
    @JoinColumn(name = "bank_account_iban")
    private BankAccount bankAccount;

    public ExternalTransfer() {
        super();
    }

    public ExternalTransfer(BigDecimal amount, String description, Date transactionDate, String status, BigDecimal fees, BankAccount bankAccount) {
        super(amount, description, transactionDate, status);
    }

    public BigDecimal getFees() {
        return fees;
    }

    public void setFees(BigDecimal fees) {
        this.fees = fees;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "ExternalTransfer{" +
                "fees=" + fees +
                ", bankAccount=" + bankAccount +
                '}';
    }
}

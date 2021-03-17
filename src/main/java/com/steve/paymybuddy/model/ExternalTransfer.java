package com.steve.paymybuddy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "external_transfer")
public class ExternalTransfer {
    @Id
    @Column(name = "transfer_id")
    private int transferId;
    @Column(name = "fees")
    private double fees;
    @Column(name = "bank_account_iban")
    private String bankAccountIban;

    public ExternalTransfer() {
    }

    public ExternalTransfer(int transferId, double fees, String bankAccountIban) {
        this.transferId = transferId;
        this.fees = fees;
        this.bankAccountIban = bankAccountIban;
    }
}

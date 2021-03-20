package com.steve.paymybuddy.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "internal_transfer")
@PrimaryKeyJoinColumn(name = "transfer_id") // PK de l'entité mere
public class InternalTransfer extends Transfer{

    @JoinColumn(name = "sender")
    @ManyToOne
    private User userSender;

    @JoinColumn(name = "receiver")
    @ManyToOne
    private User userReceiver;

    public InternalTransfer() {
    }

    public InternalTransfer(BigDecimal amount, String description, Date transactionDate, String status, User userSender, User userReceiver) {
        super(amount, description, transactionDate, status);
        this.userSender = userSender;
        this.userReceiver = userReceiver;
    }

    public User getUserSender() {
        return userSender;
    }

    public void setUserSender(User userSender) {
        this.userSender = userSender;
    }

    public User getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(User userReceiver) {
        this.userReceiver = userReceiver;
    }

    @Override
    public String toString() {
        return "InternalTransfer{" +
                "userSender=" + userSender +
                ", userReceiver=" + userReceiver +
                '}';
    }
}

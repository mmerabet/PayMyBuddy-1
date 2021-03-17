package com.steve.paymybuddy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "internal_transfer")
public class InternalTransfer {
    @Id
    @Column(name = "transfer_id")
    private int transfer_id;
    @Column(name = "sender")
    private int sender;
    @Column(name = "receiver")
    private int receiver;

    public InternalTransfer() {
    }

    public InternalTransfer(int transfer_id, int sender, int receiver) {
        this.transfer_id = transfer_id;
        this.sender = sender;
        this.receiver = receiver;
    }
}

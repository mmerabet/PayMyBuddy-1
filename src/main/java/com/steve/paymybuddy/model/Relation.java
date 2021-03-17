package com.steve.paymybuddy.model;

import javax.persistence.*;

@Entity
@Table(name = "relation")
public class Relation {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "owner")
    private int owner;

    @Column(name = "buddy")
    private int buddy;

    public Relation() {
    }

    public Relation(int owner, int buddy) {
        this.owner = owner;
        this.buddy = buddy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getBuddy() {
        return buddy;
    }

    public void setBuddy(int buddy) {
        this.buddy = buddy;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "id=" + id +
                ", owner=" + owner +
                ", buddy=" + buddy +
                '}';
    }
}

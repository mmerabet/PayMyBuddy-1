package com.steve.paymybuddy.model;

import javax.persistence.*;

@Entity
@Table(name = "relation", uniqueConstraints = @UniqueConstraint(columnNames = {"owner", "buddy"}))
public class Relation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "owner")
    @ManyToOne
    private User owner;

    @JoinColumn(name = "buddy")
    @ManyToOne
    private User buddy;

    public Relation() {
    }

    public Relation(User owner, User buddy) {
        this.owner = owner;
        this.buddy = buddy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getBuddy() {
        return buddy;
    }

    public void setBuddy(User buddy) {
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

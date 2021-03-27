package com.steve.paymybuddy.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column
    private Date createDate;

    @OneToOne
    @JoinColumn(name = "iban")
    private BankAccount bankAccount;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Relation> relations;

    public User() {
    }

    public User(Integer id, String firstName, String lastName, String email, String password, BigDecimal balance, Date createDate, BankAccount bankAccount) {
        this.id = id;
        this.firstname = firstName;
        this.lastname = lastName;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.createDate = createDate;
        this.bankAccount = bankAccount;
    }

    public User(String firstName, String lastName, String email, String password, BigDecimal balance, Date createDate, BankAccount bankAccount) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.createDate = createDate;
        this.bankAccount = bankAccount;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", createDate=" + createDate +
                ", bankAccount=" + bankAccount +
                ", relations=" + relations +
                '}';
    }
}

package com.piotrzalecki.homeserver.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accounts_statuses")
public class AccountStatus{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private double balance;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date updated;

    public AccountStatus(){}

    public AccountStatus(Long id, Account account, double balance) {
        this.account = account;
        this.balance = balance;
        this.updated = new Date();
    }

    public AccountStatus(Account account, double balance) {
        this.account = account;
        this.balance = balance;
        this.updated = new Date();
    }


    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

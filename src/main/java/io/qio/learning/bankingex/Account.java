package io.qio.learning.bankingex;

import java.util.Date;

public class Account {
    private int accountId;
    private double balance;

    private Date createdDate;

    public Account(int accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
        this.createdDate = new Date(System.currentTimeMillis());
    }

    public Account() {
        this.createdDate = new Date(System.currentTimeMillis());
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}

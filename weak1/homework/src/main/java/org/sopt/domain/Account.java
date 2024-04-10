package org.sopt.domain;

import lombok.Generated;
import lombok.Getter;


public class Account extends Bank{

    private String accountNumber;
    private double balance;
    private String password;

    public Account(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance =0;
    }

    //입금
    public boolean deposit(double amount) {
        balance += amount;
        return true;
    }

    //출금
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
    public String getPassword() {
        return password;
    }
}

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
    public void deposit(double amount) {
        balance += amount;
    }

    //출금
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    //이체
    public void transfer(Account recipient, double amount) {
        if (withdraw(amount)) {
            recipient.deposit(amount);
        }
    }

    //비밀번호 인증
    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

package org.sopt.domain;

import lombok.Getter;

@Getter
public class Account extends Bank{
    private Long id;
    private String accountNumber;
    private double balance;
    private String password;

    public Account(Long id, String accountNumber, double balance, String password) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.password = password;
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
}

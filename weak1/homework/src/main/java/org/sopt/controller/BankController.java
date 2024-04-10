package org.sopt.controller;

import org.sopt.domain.Account;
import org.sopt.domain.Bank;

import java.util.ArrayList;
import java.util.List;

public class BankController {
    private Bank bank;
    private List<Account> accounts; //db연동 없기때문에 list로 선언

    public BankController(Bank bank) {
        this.bank = bank;
        this.accounts = new ArrayList<>();
    }

    public void createAccount(Long id, String accountNumber, double balance, String password) {

        Account account = new Account(id, accountNumber, balance, password);
        accounts.add(account);
    }

}

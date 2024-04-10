package org.sopt.controller;

import org.sopt.domain.Account;
import org.sopt.domain.Bank;
import org.sopt.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class BankController {
    private Bank bank;
    private List<Customer> customers;
    private List<Account> accounts;

    public BankController(Bank bank) {
        this.bank = bank;
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    // 고객을 추가하는 메서드
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // 비밀번호로 고객을 찾는 메서드
    private Customer findCustomerByPassword(String customerName, String customerPassword) {
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName) && customer.getPassword().equals(customerPassword)) {
                return customer;
            }
        }
        return null;
    }

    // 계좌로 고객을 찾는 메서드
    private Account findCustomerByAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account ;
            }
        }
        return null;
    }

    // 계좌를 생성하는 메서드
    public Account createAccount(String customerName, String customerPassword, String accountNumber, String password) {
        // 고객 찾기
        Customer customer = findCustomerByPassword(customerName, customerPassword);
        if (customer != null) {
            Account account = new Account(accountNumber, password);
            accounts.add(account);
            System.out.println(customerName + "님의 계좌가 생성되었습니다.");
            return account;
        } else {
            System.out.println("정보가 일치하지 않습니다. 다시 확인해주세요.");
            return null;
        }
    }
    // 입금 기능 구현
    public void deposit (String customerName, String accountNumber,double amount){
        // 이름으로 고객 찾기
        Account account = findCustomerByAccount(customerName);
        if (account == null) {
            System.out.println("고객 혹은 계좌를 찾을 수 없습니다.");
            return;
        }

        // 입금
        boolean success = account.deposit(amount);
        if (success) {
            System.out.println(amount + "원이 입금되었습니다.");
        }
    }

    // 출금 기능 구현
    public void withdraw (String customerName, String accountNumber,double amount){
        // 이름으로 고객 찾기
        Account account = findCustomerByAccount(customerName);
        if (account == null) {
            System.out.println("고객 혹은 계좌를 찾을 수 없습니다.");
            return;
        }

        // 출금
        boolean success = account.withdraw(amount);
        if (success) {
            System.out.println(amount + "원이 출금되었습니다.");
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }
}

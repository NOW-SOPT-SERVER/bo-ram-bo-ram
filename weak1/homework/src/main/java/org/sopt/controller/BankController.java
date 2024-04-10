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
    private Customer findCustomerByAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return ;
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
            System.out.println(customerName+"님의 계좌가 생성되었습니다.");
            return account;
        } else {
            System.out.println("정보가 일치하지 않습니다. 다시 확인해주세요.");
            return null;
        }


    }
}

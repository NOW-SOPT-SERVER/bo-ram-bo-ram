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
    // 고객명으로 고객을 반환하는 메서드
    private Customer findCustomer(String customerName) {
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName) ) {
                return customer;
            }
        }
        return null;
    }

    // 고객명과 비밀번호로 고객을 반환하는 메서드
    private Customer findCustomerByPassword(String customerName, String customerPassword) {
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName) && customer.getPassword().equals(customerPassword)) {
                return customer;
            }
        }
        return null;
    }

    // 계좌번호로 일치하는 계좌를 반환하는 메소드
    public Account findAccountByAccountNumber(String accountNumber,String accountPassword) {

        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.getPassword().equals(accountPassword)) {
                return account;
            }
        }

        System.out.println("입력한 정보 해당하는 계좌를 찾을 수 없습니다.");
        return null;
    }




    // 입금 기능 구현
    public void deposit (String accountNumber,String accountPassword, double amount){
        // 계좌번호로 계좌찾기
        Account account = findAccountByAccountNumber(accountNumber,accountPassword);
        if (account == null) {
            System.out.println("계좌를 찾을 수 없습니다.");
            return;
        }

        // 입금
        boolean success = account.deposit(amount);
        if (success) {
            System.out.println(amount + "원이 입금되었습니다.");
        }
    }

    // 출금 기능 구현
    public void withdraw (String accountNumber,String accountPassword,double amount){
        // 계좌번호로 계좌 찾기
        Account account = findAccountByAccountNumber(accountNumber,accountPassword);
        if (account == null) {
            System.out.println("계좌를 찾을 수 없습니다.");
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

    //잔액 확인 기능 구현
    public void getBalance(String accountNumber,String accountPassword){
        // 계좌번호로 계좌찾기
        Account account = findAccountByAccountNumber(accountNumber,accountPassword);
        if (account == null) {
            System.out.println("고객 혹은 계좌를 찾을 수 없습니다.");
            return;
        }

        // 잔액 조회
        System.out.println("계좌 잔액: " + account.getBalance() + "원");
    }
}

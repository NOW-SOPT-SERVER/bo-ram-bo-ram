package org.sopt.controller;

import org.sopt.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    private List<Customer> customers;

    public CustomerController() {
        this.customers = new ArrayList<>();
    }

    public void createCustomer(String name) {
        Customer customer = new Customer(name);
        customers.add(customer);
        System.out.println("환영합니다 " + customer.getName() + "님 \n");
    }
}

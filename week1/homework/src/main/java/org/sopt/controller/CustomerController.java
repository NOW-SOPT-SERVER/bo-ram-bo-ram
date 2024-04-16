package org.sopt.controller;

import org.sopt.domain.Customer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    private List<Customer> customers;

    public CustomerController() {
        this.customers = new ArrayList<>();
    }

    public Customer createCustomer(String name,String password) {
        Customer customer = new Customer(name, password);
        CustomerController customerController =new CustomerController();


        customers.add(customer);
        System.out.println("환영합니다 " + customer.getName() + "님 \n");

        //bankCu.addCustomer(customer);
        return customer;
    }

}

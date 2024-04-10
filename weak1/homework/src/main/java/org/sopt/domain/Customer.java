package org.sopt.domain;

import lombok.Generated;

public class Customer {

    private String name;
    private String password;

    public Customer(String name,String password) {
        this.name = name;
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
}

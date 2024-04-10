package org.sopt.domain;

import lombok.Generated;
import lombok.Getter;

@Getter
public class Customer {

    @Generated
    private Long id;
    private String name;

    public Customer( String name) {
        this.name = name;
    }
}

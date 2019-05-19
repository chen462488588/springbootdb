package com.chen.entity;

import org.springframework.stereotype.Component;

@Component
public class Address {
    private static  String address = "hubei";

    @Override
    public String toString() {
        return address;
    }
}

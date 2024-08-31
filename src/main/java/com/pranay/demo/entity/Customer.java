package com.pranay.demo.entity;

import lombok.Data;

@Data
public class Customer {
    private String name;
    private String phoneNumber;
    private String email;
    private Location location;
}
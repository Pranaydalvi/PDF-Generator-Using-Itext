package com.pranay.demo.entity;

import java.util.List;

import lombok.Data;

@Data
public class Purchase {
    private Integer purchaseId;
    private String purchaseDate;
    private Customer customer;
    private Transaction transaction;
    private List<Product> products;
}
package com.pranay.demo.entity;

import lombok.Data;

@Data
public class Product {
    private String productId;
    private String productName;
    private Integer quantity;
    private double unitPrice;
}
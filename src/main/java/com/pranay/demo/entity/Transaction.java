package com.pranay.demo.entity;

import lombok.Data;

@Data
public class Transaction {
    private double totalAmount;
    private String paymentMethod;
    private String transactionId;
}
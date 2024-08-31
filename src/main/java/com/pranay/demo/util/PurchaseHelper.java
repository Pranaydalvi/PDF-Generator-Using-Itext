package com.pranay.demo.util;

import java.util.ArrayList;
import java.util.List;

import com.pranay.demo.entity.Customer;
import com.pranay.demo.entity.Location;
import com.pranay.demo.entity.Product;
import com.pranay.demo.entity.Purchase;
import com.pranay.demo.entity.Transaction;

public class PurchaseHelper {

    public static Purchase getPurchase() {
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(5678);
        purchase.setPurchaseDate("2024-08-31");

        Location location = new Location();
        location.setCity("Pune");
        location.setStreet("1234 Market Street");
        location.setPostalCode("411033");
        location.setState("Maharashtra");

        Customer customer = new Customer();
        customer.setPhoneNumber("8989898989");
        customer.setEmail("pramodkhandare0050.com");
        customer.setName("Pramod Khandare");
        customer.setLocation(location);
        purchase.setCustomer(customer);

        List<Product> products = new ArrayList<>();
        purchase.setProducts(products);

        Product product1 = new Product();
        product1.setProductName("Wireless Mouse");
        product1.setUnitPrice(29.99);
        product1.setQuantity(1);
        product1.setProductId("200056");
        products.add(product1);

        Product product2 = new Product();
        product2.setProductName("Keyboard");
        product2.setUnitPrice(49.99);
        product2.setProductId("200078");
        product2.setQuantity(2);
        products.add(product2);

        Transaction transaction = new Transaction();
        double totalAmount = products.stream().mapToDouble(product -> product.getUnitPrice() * product.getQuantity()).sum();
        transaction.setTotalAmount(totalAmount);
        transaction.setPaymentMethod("Credit Card");
        transaction.setTransactionId("TXN1234567890");
        purchase.setTransaction(transaction);

        return purchase;
    }
}
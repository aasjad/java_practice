package com.ecommerce.exception;

public class OrderNotFoundException extends OrderException {
    public OrderNotFoundException(String orderId) {
        super("ORD-001", "Order not found: " + orderId);
    }
}

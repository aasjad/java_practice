package com.ecommerce.exception;

public class OrderAlreadyCancelledException extends OrderException {
    public OrderAlreadyCancelledException(String orderId) {
        super("ORD-002", "Order already cancelled: " + orderId);
    }
}

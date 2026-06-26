package com.ecommerce.exception;

public class OrderNotEligibleException extends OrderException {
    public OrderNotEligibleException(String orderId, String reason) {
        super("ORD-003", "Order not eligible for return/refund: " + orderId + " - " + reason);
    }
}

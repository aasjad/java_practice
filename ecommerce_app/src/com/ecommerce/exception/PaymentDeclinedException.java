package com.ecommerce.exception;

public class PaymentDeclinedException extends PaymentException {
    private final String reason;

    public PaymentDeclinedException(String orderId, String reason) {
        super("PAY-001", "Payment declined for order " + orderId + ": " + reason);
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}

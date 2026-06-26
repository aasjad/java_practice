package com.ecommerce.exception;

public class InsufficientCreditException extends PaymentException {
    private final double required;
    private final double available;

    public InsufficientCreditException(String orderId, double required, double available) {
        super("PAY-002", "Insufficient credit for order " + orderId + ": required=" + required + " available=" + available);
        this.required = required;
        this.available = available;
    }

    public double getRequired() {
        return required;
    }

    public double getAvailable() {
        return available;
    }
}

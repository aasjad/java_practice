package com.ecommerce.model;

public class Order {
    private final String orderId;
    private final String productId;
    private final int quantity;
    private final double expectedPrice;
    private final boolean paymentAuthorized;
    private final double creditAvailable;
    private boolean cancelled;
    private boolean processed;

    public Order(String orderId, String productId, int quantity, double expectedPrice, boolean paymentAuthorized, double creditAvailable, boolean cancelled) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.expectedPrice = expectedPrice;
        this.paymentAuthorized = paymentAuthorized;
        this.creditAvailable = creditAvailable;
        this.cancelled = cancelled;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getExpectedPrice() {
        return expectedPrice;
    }

    public double getTotalAmount() {
        return expectedPrice * quantity;
    }

    public boolean isPaymentAuthorized() {
        return paymentAuthorized;
    }

    public double getCreditAvailable() {
        return creditAvailable;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }
}

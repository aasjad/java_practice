package com.ecommerce.exception;

public class OutOfStockException extends ProductException {
    private final String productId;
    private final int requestedQty;
    private final int availableQty;

    public OutOfStockException(String productId, int requestedQty, int availableQty) {
        super("PROD-002", "Product out of stock: " + productId + " requested=" + requestedQty + " available=" + availableQty);
        this.productId = productId;
        this.requestedQty = requestedQty;
        this.availableQty = availableQty;
    }

    public String getProductId() {
        return productId;
    }

    public int getRequestedQty() {
        return requestedQty;
    }

    public int getAvailableQty() {
        return availableQty;
    }
}

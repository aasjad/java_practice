package com.ecommerce.exception;

public class PriceChangedException extends ProductException {
    private final double oldPrice;
    private final double newPrice;

    public PriceChangedException(String productId, double oldPrice, double newPrice) {
        super("PROD-003", "Price changed for product: " + productId + " oldPrice=" + oldPrice + " newPrice=" + newPrice);
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }
}

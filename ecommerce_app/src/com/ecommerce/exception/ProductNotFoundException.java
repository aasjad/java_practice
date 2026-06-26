package com.ecommerce.exception;

public class ProductNotFoundException extends ProductException {
    public ProductNotFoundException(String productId) {
        super("PROD-001", "Product not found: " + productId);
    }
}

package com.ecommerce.model;

public class Product {
    private final String productId;
    private final String name;
    private final double price;
    private int availableQty;

    public Product(String productId, String name, double price, int availableQty) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.availableQty = availableQty;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableQty() {
        return availableQty;
    }

    public void deductQuantity(int qty) {
        availableQty -= qty;
    }
}

package com.ecommerce.service;

import com.ecommerce.exception.InsufficientCreditException;
import com.ecommerce.exception.OrderAlreadyCancelledException;
import com.ecommerce.exception.OrderNotEligibleException;
import com.ecommerce.exception.OrderNotFoundException;
import com.ecommerce.exception.OutOfStockException;
import com.ecommerce.exception.PaymentDeclinedException;
import com.ecommerce.exception.PriceChangedException;
import com.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.model.Order;
import com.ecommerce.model.Product;

import java.util.HashMap;
import java.util.Map;

public class OrderService {
    private final Map<String, Order> orders = new HashMap<>();
    private final Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public void processOrder(String orderId) throws Exception {
        Order order = orders.get(orderId);
        if (order == null) {
            throw new OrderNotFoundException(orderId);
        }
        if (order.isCancelled()) {
            throw new OrderAlreadyCancelledException(orderId);
        }
        Product product = products.get(order.getProductId());
        if (product == null) {
            throw new ProductNotFoundException(order.getProductId());
        }
        if (product.getAvailableQty() < order.getQuantity()) {
            throw new OutOfStockException(order.getProductId(), order.getQuantity(), product.getAvailableQty());
        }
        if (product.getPrice() != order.getExpectedPrice()) {
            throw new PriceChangedException(order.getProductId(), order.getExpectedPrice(), product.getPrice());
        }
        if (!order.isPaymentAuthorized()) {
            throw new PaymentDeclinedException(orderId, "Authorization failed");
        }
        if (order.getCreditAvailable() < order.getTotalAmount()) {
            throw new InsufficientCreditException(orderId, order.getTotalAmount(), order.getCreditAvailable());
        }

        product.deductQuantity(order.getQuantity());
        order.setProcessed(true);
    }
}

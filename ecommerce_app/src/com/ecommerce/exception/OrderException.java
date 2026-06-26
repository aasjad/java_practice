package com.ecommerce.exception;

public abstract class OrderException extends EcommerceException {
    protected OrderException(String errorCode, String message) {
        super(errorCode, message);
    }
}

package com.ecommerce.exception;

public abstract class ProductException extends EcommerceException {
    protected ProductException(String errorCode, String message) {
        super(errorCode, message);
    }
}

package com.ecommerce.exception;

public abstract class PaymentException extends EcommerceException {
    protected PaymentException(String errorCode, String message) {
        super(errorCode, message);
    }
}

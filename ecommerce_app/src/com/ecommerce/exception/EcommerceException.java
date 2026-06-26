package com.ecommerce.exception;

public abstract class EcommerceException extends Exception {
    private final String errorCode;

    protected EcommerceException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

package com.morrs.domain.exceptions;

public abstract class BaseException extends RuntimeException {
    protected int statusCode;

    public BaseException(String message) {
        super(message);
    }

    public int getStatusCode() {
        return statusCode;
    }
}

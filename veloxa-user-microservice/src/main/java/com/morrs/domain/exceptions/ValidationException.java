package com.morrs.domain.exceptions;

public class ValidationException extends BaseException {
    public ValidationException(String message) {
        super(message);
        this.statusCode = 422;
    }
}

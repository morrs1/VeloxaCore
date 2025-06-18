package com.morrs.veloxameetingmicroservice.exceptions;

public class DuplicateKeyException extends BaseException {
    public DuplicateKeyException(String message) {
        super(message);
        this.statusCode = 422;
    }
}

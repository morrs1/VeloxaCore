package com.morrs.veloxameetingmicroservice.exceptions;

import com.morrs.veloxameetingmicroservice.domain.exceptions.BaseException;

public class DuplicateKeyException extends BaseException {
    public DuplicateKeyException(String message) {
        super(message);
        this.statusCode = 422;
    }
}

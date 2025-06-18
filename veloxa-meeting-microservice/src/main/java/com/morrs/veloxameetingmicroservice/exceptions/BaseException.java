package com.morrs.veloxameetingmicroservice.exceptions;

import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException {
    protected int statusCode;

    public BaseException(String message) {
        super(message);
    }
}

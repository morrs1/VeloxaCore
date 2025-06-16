package com.morrs.spi.exceptions;

import com.morrs.domain.exceptions.BaseException;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException(String message) {
        super(message);
        this.statusCode = 404;
    }
}

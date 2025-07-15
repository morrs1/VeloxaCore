package com.morrs.veloxameetingmicroservice.exceptions;

import com.morrs.veloxameetingmicroservice.domain.exceptions.BaseException;

public class MeetingNotFoundException extends BaseException {
    public MeetingNotFoundException(String message) {
        super(message);
        this.statusCode = 404;
    }
}

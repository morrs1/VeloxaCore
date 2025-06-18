package com.morrs.veloxameetingmicroservice.exceptions;

public class MeetingNotFoundException extends BaseException {
    public MeetingNotFoundException(String message) {
        super(message);
        this.statusCode = 404;
    }
}

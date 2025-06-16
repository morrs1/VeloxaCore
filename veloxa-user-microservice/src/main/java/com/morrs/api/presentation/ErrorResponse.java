package com.morrs.api.presentation;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponse(String message, HttpStatus httpStatus, LocalDateTime timestamp) {
}

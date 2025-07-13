package com.morrs.veloxameetingmicroservice.api.exceptionHandlers;

import com.morrs.veloxameetingmicroservice.api.presentation.ErrorResponse;
import com.morrs.veloxameetingmicroservice.domain.exceptions.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class ErrorsHandler {

	@ExceptionHandler(BaseException.class)
	public ResponseEntity<ErrorResponse> handleBaseException(BaseException e) {
		log.warn("{} {}", e.getClass().getSimpleName(), e.getMessage());
		return ResponseEntity.status(e.getStatusCode())
				.body(new ErrorResponse(
								e.getMessage(),
								HttpStatus.valueOf(e.getStatusCode()),
								LocalDateTime.now()
						)
				);
	}

}

package com.spring.jdbc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for handling specific and generic exceptions in the application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = ErrorWhileExecutingQuery.class)
    public ResponseEntity<String> handleCustomException(ErrorWhileExecutingQuery e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> genericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
}

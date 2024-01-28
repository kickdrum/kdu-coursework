package com.kdu.caching.exceptions;
import com.kdu.caching.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
/**
 * Global exception handler for handling custom exceptions across the application.
 */
@ControllerAdvice
public class CustomHandler {
    /**
     * Handler for IO exceptions
     * @param exception
     * @return
     */
    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorDto> handleIOException(IOException exception) {
        ErrorDto errorDTO = new ErrorDto(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handler for Client error exception
     * @param exception
     * @return
     */
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorDto> handleIOException(HttpClientErrorException exception) {
        ErrorDto errorDTO = new ErrorDto(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
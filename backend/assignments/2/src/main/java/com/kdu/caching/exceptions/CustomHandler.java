package com.kdu.caching.exceptions;
import com.kdu.caching.dto.ErrorDto;
//import com.kdu.caching.exceptions.custom.MyException;
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
//    `@ExceptionHandler(MyException.class)
//    public ResponseEntity<ErrorDto> handleMyException(MyException ex) {
//        ErrorDto errorDTO = new ErrorDto(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
//        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
//    }`

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorDto> handleIOException(IOException ex) {
        ErrorDto errorDTO = new ErrorDto("Bad data", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorDto> handleIOException(HttpClientErrorException ex) {
        ErrorDto errorDTO = new ErrorDto("Server Issue", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
package com.example.assessment2.exception;

import com.example.assessment2.dto.ErrorDto;
import com.example.assessment2.exception.custom.MyCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {MyCustomException.class})
    public ResponseEntity<ErrorDto> handleCustomException(MyCustomException ex) {
        ErrorDto error = new ErrorDto(ex.getMessage() + " [MyCustomException]", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
package com.example.springboot3.exception;

import com.example.springboot3.dto.ErrorDto;
import com.example.springboot3.exception.custom.BadRequestException;
import com.example.springboot3.exception.custom.CustomNullException;
import com.example.springboot3.exception.custom.ResourceNotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Profile("dev")
    @ExceptionHandler(value={ResourceNotFoundException.class})
    public ResponseEntity<ErrorDto> handleCustomException(ResourceNotFoundException ex){
        ErrorDto error= new ErrorDto(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Profile("dev")
    @ExceptionHandler(value={CustomNullException.class})
    public ResponseEntity<ErrorDto> handleCustomNullException(CustomNullException ex){
        ErrorDto error=new ErrorDto(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value={BadRequestException.class})
    public ResponseEntity<ErrorDto> handleBadRequestException(CustomNullException ex){
        ErrorDto error=new ErrorDto(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorDto> AllKindOfExceptions(Exception ex){
        ErrorDto error= new ErrorDto(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

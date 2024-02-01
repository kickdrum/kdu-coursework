package com.example.Security.exceptions;

import com.example.Security.dto.Errordto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExpHandler {
    @ExceptionHandler(value = {CustomExp.class})
    public ResponseEntity<Errordto> handleCustomException(CustomExp ex){
        Errordto error = new Errordto(ex.getMessage() + " [MyCustomException]", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Errordto> allKindOfExceptions(Exception ex){
        Errordto error = new Errordto(ex.getMessage() + " [Global Exception]", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

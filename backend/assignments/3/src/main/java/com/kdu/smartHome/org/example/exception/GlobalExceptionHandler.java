package org.example.exception;


import org.example.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value={CustomException.class})
    public ResponseEntity<ErrorDto> myCustomException(CustomException ex){
        ErrorDto error=new ErrorDto(ex.getMessage(),HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value={Exception.class})
    public ResponseEntity<ErrorDto> exception(Exception ex){
        ErrorDto error=new ErrorDto(ex.getMessage(),HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
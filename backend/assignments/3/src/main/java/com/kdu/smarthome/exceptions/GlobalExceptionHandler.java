package com.kdu.smarthome.exceptions;


import com.kdu.smarthome.dto.response.ErrorDTO;
import com.kdu.smarthome.exceptions.custom.EntityNotCreatedException;
import com.kdu.smarthome.exceptions.custom.InvalidCredentialsException;
import com.kdu.smarthome.exceptions.custom.InvalidDeviceCredentialsException;
import com.kdu.smarthome.exceptions.custom.ResourceNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler{

    @ExceptionHandler(value = {EntityNotCreatedException.class})
    public ResponseEntity<ErrorDTO> entityNotCreatedException(Exception ex){
        log.error("EntityNotCreatedException: " + ex.getMessage());
        ErrorDTO error = new ErrorDTO("Invalid request ", ex.getMessage() , HttpStatus.NOT_ACCEPTABLE.value());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }


    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    public ResponseEntity<ErrorDTO> dataIntegrityViolationException(Exception ex){
        log.error("EntityNotCreatedException: " + ex.getMessage());
        ErrorDTO error = new ErrorDTO("Invalid Data", ex.getMessage() , HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<ErrorDTO> constraintViolationException(Exception ex){
        log.error("ConstraintViolationException: " + ex.getMessage());
        ErrorDTO error = new ErrorDTO("Invalid Parameter", ex.getMessage() , HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ErrorDTO> resourceNotFoundException(Exception ex){
        log.error("ResourceNotFoundException: " + ex.getMessage());
        ErrorDTO error = new ErrorDTO("Resource Not Found", ex.getMessage() , HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = {InvalidCredentialsException.class})
    public ResponseEntity<ErrorDTO> invalidCredentialsException(Exception ex){
        log.error("InvalidCredentialsException: " + ex.getMessage());
        ErrorDTO error = new ErrorDTO("Invalid Credentials Exception", ex.getMessage() , HttpStatus.UNAUTHORIZED.value());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }


    @ExceptionHandler(value = {InvalidDeviceCredentialsException.class})
    public ResponseEntity<ErrorDTO> invalidDeviceCredentialsException(Exception ex){
        log.error("InvalidDeviceCredentialsException: " + ex.getMessage());
        ErrorDTO error = new ErrorDTO("Invalid Device Credentials Exception", ex.getMessage() , HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorDTO> allKindOfExceptions(Exception ex){
        log.error("allKindOfExceptions: " + ex.getMessage());
        log.error("allKindOfExceptions: " + ex.getClass());
        ErrorDTO error = new ErrorDTO("INTERNAL_SERVER_ERROR", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
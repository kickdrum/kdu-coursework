package com.example.springhandson4.exception.custom;

public class DataTypeException extends RuntimeException {
    public DataTypeException(String message) {
        super(message);
    }
}
package com.example.springhandson5.exception.custom;

public class CustomException extends IndexOutOfBoundsException{
    public CustomException(String message){
        super(message);
    }
}

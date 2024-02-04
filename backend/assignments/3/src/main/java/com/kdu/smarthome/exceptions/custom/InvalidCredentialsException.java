package com.kdu.smarthome.exceptions.custom;

public class InvalidCredentialsException extends Exception{
    public InvalidCredentialsException(String msg){
        super(msg);
    }
}
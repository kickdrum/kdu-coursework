package com.example.springboot3.exception.custom;

public class CustomNullException extends NullPointerException{
    public CustomNullException(String s){
        super(s);
    }
}
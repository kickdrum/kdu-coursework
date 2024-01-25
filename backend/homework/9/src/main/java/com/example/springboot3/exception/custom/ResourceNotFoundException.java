package com.example.springboot3.exception.custom;


public class ResourceNotFoundException extends IndexOutOfBoundsException{
    public ResourceNotFoundException(String s){
        super(s);
    }
}

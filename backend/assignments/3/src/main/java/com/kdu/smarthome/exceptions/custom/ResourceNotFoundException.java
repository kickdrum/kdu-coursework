package com.kdu.smarthome.exceptions.custom;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
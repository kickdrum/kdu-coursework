package com.sanskar.homeworkspring3.exception;

public class MyCustomException extends IndexOutOfBoundsException{
    public MyCustomException(String s) {
        super(s);
    }
}

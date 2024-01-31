package com.spring.jdbc.exception;

public class ErrorWhileExecutingQuery extends RuntimeException{
    public ErrorWhileExecutingQuery(String msg){
        super(msg);
    }
}

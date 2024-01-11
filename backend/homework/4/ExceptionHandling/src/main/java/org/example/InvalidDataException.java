package org.example;

public class InvalidDataException extends RuntimeException{

    Exception exception;
    InvalidDataException(Exception exception){
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "InvalidDataException{" +
                "exception=" + exception +
                '}';
    }
}


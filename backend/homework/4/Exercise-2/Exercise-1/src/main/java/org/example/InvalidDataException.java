package org.example;

public class InvalidDataException extends RuntimeException {

    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
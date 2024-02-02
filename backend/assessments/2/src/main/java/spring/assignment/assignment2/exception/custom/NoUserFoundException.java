package spring.assignment.assignment2.exception.custom;

public class NoUserFoundException extends RuntimeException{
    public NoUserFoundException(String message) {
        super(message);
    }
}

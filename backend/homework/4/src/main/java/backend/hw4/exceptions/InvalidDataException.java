package backend.hw4.exceptions;

/*creating a custom "unchecked" exception that would take a cause, i.e., we're implementing exception chaining*/

public class InvalidDataException extends RuntimeException{
    InvalidDataException (String msge, Throwable cause){
        super(msge,cause);
    }
}

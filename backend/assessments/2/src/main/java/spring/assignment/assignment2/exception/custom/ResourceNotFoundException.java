package spring.assignment.assignment2.exception.custom;


public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

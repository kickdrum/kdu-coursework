package shrishti.example.question1;

public class InvalidDataException extends RuntimeException {
    InvalidDataException(String message, MissingGradeException cause) {
        super(message, cause);
    }
}

package question1;

public class InvalidDataException extends RuntimeException{
        private int studentId;
        public InvalidDataException(String message, MissingGradeException cause){
                super(message, cause);
        }

}

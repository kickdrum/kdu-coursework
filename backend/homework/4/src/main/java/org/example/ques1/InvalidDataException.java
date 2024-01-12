package org.example.ques1;

public class InvalidDataException extends RuntimeException{
        private int studentId;

        /**
         *
         * @param message
         * @param cause
         */
        public InvalidDataException(String message, MissingGradeException cause){
                super(message, cause);
        }

}

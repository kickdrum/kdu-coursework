package backend.hw4.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static backend.hw4.exceptions.StudentUtil.calculateGPA;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main (String[] args){
        try {
            int[] studentIdList1 = {1001, 1002};
            char[][] studentsGrades1 = {{'A', 'A', 'A', 'B'}};
            calculateGPA(studentIdList1, studentsGrades1);
        } catch (IllegalArgumentException | MissingGradeException exception) {
            String errorMessage = String.format("IllegalArgumentException caught: %s",exception.getMessage());
            logger.error(errorMessage);        }
        try {
            int[] studentIdList1 = {1001};
            char[][] studentsGrades2 = { {'A', ' ', 'B'} };
            calculateGPA(studentIdList1, studentsGrades2);
        } catch (MissingGradeException exception) {
            String formattedMessage = String.format("Missing grade for student: %d",exception.getStudentId());
            throw new InvalidDataException(formattedMessage, exception);
        }

    }

}
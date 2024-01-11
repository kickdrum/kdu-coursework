package org.example.ques1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     *
     * @param args
     */
    public static void main (String[] args) {
        try {
            Student student = new Student();
            int[] studentIdList1 = {1001, 1002};
            char[][] studentsGrades1 = {{'A', 'A', 'A', 'B'}};
            double[] gpa = student.calculateGPA(studentIdList1, studentsGrades1);
        }
        catch (IllegalArgumentException | MissingGradeException exception) {
            logger.info("{}","IllegalArgumentException caught: " + exception.getMessage());
        }

        try {
            Student student = new Student();
            int[] studentIdList1 = {1001};
            char[][] studentsGrades2 = {{'A', ' ', 'B'}};
            double[] gpa = student.calculateGPA(studentIdList1, studentsGrades2);
        }

         catch (MissingGradeException exception) {
            String formattedMessage = String.format("Missing grade for student: %d", exception.getStudentId());
            throw new InvalidDataException(formattedMessage, exception);
        }
    }
}
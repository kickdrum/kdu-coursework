package kdu.homework;


import static kdu.homework.StudentUtil.calculateGPA;

public class Main {
    public static void main(String[] args) {

        // given inputs
        double lower = 2;
        double higher = 10;
        int[] studentIdList = {1001};
        char[][] studentsGrades = { { 'B', 'A', 'A', 'B' }};

        // invoking method
        int[] result = StudentUtil.getStudentsByGPA(lower, higher, studentIdList, studentsGrades);

        // creating Log instance
        Logs logger = new Logs();

        // logging final results
        if(result==null || result.length==0){
            logger.console("No student exists");
            return;
        }

        logger.console("Student Ids having average marks in given range are: ");

        for (double id : result) {
            logger.console(Double.toString(id));
        }

    }
}
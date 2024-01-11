package org.example.question1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class studentutil {
    private static final Logger logger = LoggerFactory.getLogger(studentutil.class);

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws missinggradeexception {
        if (studentIdList.length != studentsGrades.length) {
            throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length: " + studentIdList.length + ", studentsGrades.length: " + studentsGrades.length);
        }

        double[] gpaList = new double[studentIdList.length];

        for (int i = 0; i < studentsGrades.length; i++) {
            double gpa = 0.0;

            for (int j = 0; j < studentsGrades[i].length; j++) {
                if (studentsGrades[i][j] == 'A') {
                    gpa += 4.0;
                } else if (studentsGrades[i][j] == 'B') {
                    gpa += 3.0;
                } else if (studentsGrades[i][j] == 'C') {
                    gpa += 2.0;
                } else if (studentsGrades[i][j] == ' ') {
                    throw new missinggradeexception(studentIdList[i]);
                }
            }

            gpaList[i] = gpa/studentsGrades[i].length;
        }

        return gpaList;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {

        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }
        double[] gpaList = new double[studentIdList.length];

        try {
            gpaList = calculateGPA(studentIdList, studentsGrades);
        } catch (missinggradeexception e) {
            logger.error("Exception in calculateGPA", e);
            throw new invaliddataexception(e);
        }

        int count = 0;

        for (double gpa : gpaList) {
            if (gpa >= lower && gpa <= higher) {
                count++;
            }
        }

        int[] result = new int[count];

        int index = 0;
        for (int i = 0; i <  gpaList.length; i++) {
            if (gpaList[i] >= lower && gpaList[i] <= higher) {
                result[index++] = studentIdList[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] studentIdList = {1, 2, 3};
        char[][] studentsGrades = {{'A', 'A', 'A', 'C'}, {'A', 'B', 'C', 'A'}, {'B', 'B', 'B'}};
        double[] gpaList = null;

        try {
            gpaList = calculateGPA(studentIdList, studentsGrades);
        } catch (missinggradeexception e) {
            logger.error("Exception in calculateGPA", e);

        }

        if (gpaList != null) {
            for (double gpa : gpaList) {
                logger.info("gpa: {}", gpa);
            }
        }

        int[] id = getStudentsByGPA(3.5, 4.0, studentIdList, studentsGrades);

        if (id != null) {
            for (int val : id) {
                logger.info("id: {}", val);
            }
        }
    }
}

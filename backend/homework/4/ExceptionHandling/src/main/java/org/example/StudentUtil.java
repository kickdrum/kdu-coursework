package org.example;

public class StudentUtil {

    private static final char GRADE_A = 'A';
    private static final char GRADE_B = 'B';
    private static final char GRADE_C = 'C';
    private static final char MISSING_GRADE = ' ';

    public static Logging logging = new Logging();

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException {
        if (studentIdList.length != studentsGrades.length) {
            throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length: " +
                    studentIdList.length + ", studentsGrades.length: " + studentsGrades.length);
        }

        double[] gpaList = new double[studentIdList.length];

        for (int i = 0; i < studentsGrades.length; i++) {
            double gpa = calculateStudentGPA(studentsGrades[i], studentIdList[i]);
            gpaList[i] = gpa / studentsGrades[i].length;
        }

        return gpaList;
    }

    private static double calculateStudentGPA(char[] grades, int studentId) throws MissingGradeException {
        double gpa = 0.0;

        for (char grade : grades) {
            switch (grade) {
                case GRADE_A:
                    gpa += 4.0;
                    break;
                case GRADE_B:
                    gpa += 3.0;
                    break;
                case GRADE_C:
                    gpa += 2.0;
                    break;
                case MISSING_GRADE:
                    throw new MissingGradeException(studentId);
                    // Add more cases if needed for other grades
            }
        }

        return gpa;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }

        double[] gpaList;

        try {
            gpaList = calculateGPA(studentIdList, studentsGrades);
        } catch (MissingGradeException exception) {
            logging.logString(String.format("%d has a missing grade",exception.getStudentId()));
            throw new InvalidDataException(exception);
        }

        int count = 0;
        for (double gpa : gpaList) {
            if (gpa >= lower && gpa <= higher) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < gpaList.length; i++) {
            if (gpaList[i] >= lower && gpaList[i] <= higher) {
                result[index++] = studentIdList[i];
            }
        }

        return result;
    }
}

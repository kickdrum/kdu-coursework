package backend.hw4.exceptions;

public class StudentUtil {
    private StudentUtil(){
        throw new IllegalStateException("Utility class");
    }

    /**
     * this is the calculateGPA method in which if the sizes of the input arrays are not identical, then let's throw an IllegalArgumentException
     * @param studentIdList
     * @param studentsGrades
     * @return
     * @throws MissingGradeException
     */

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException{
        if(studentsGrades.length!=studentIdList.length) {
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
                    // the student has still not received the grade
                    throw  new MissingGradeException(studentIdList[i]);
                }
            }

            gpaList[i] = gpa/studentsGrades[i].length;
        }

        return gpaList;
    }

    /**
     * here we are catching the MissingGradeException and re-throw runtime exception InvalidDataException initialized with the cause MissingGradeException
     * @param lower
     * @param higher
     * @param studentIdList
     * @param studentsGrades
     * @return
     */

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        if (lower < 0 || higher < 0 || lower > higher) {
            return new int[0];
        }

        double[] gpaList = new double[studentIdList.length];

        try {
            gpaList = calculateGPA(studentIdList, studentsGrades);
        } catch (MissingGradeException e) {
            throw new InvalidDataException("Missing Grade Exception",e);
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
}

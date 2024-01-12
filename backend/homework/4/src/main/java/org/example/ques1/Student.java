package org.example.ques1;
public class Student {
    /**
     *
     * @param studentIdList
     * @param studentsGrades
     * @return
     * @throws MissingGradeException
     */
    public double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException {

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
                    throw new MissingGradeException(studentIdList[i]);
                }
            }

            gpaList[i] = gpa / studentsGrades[i].length;
        }
        return gpaList;
    }

    /**
     *
     * @param lower
     * @param higher
     * @param studentIdList
     * @param studentsGrades
     * @return
     */

    public int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        if (lower < 0 || higher < 0 || lower > higher)
            return null;

        double[] gpaList = new double[studentIdList.length];

        try {
            gpaList = calculateGPA(studentIdList, studentsGrades);
        }
        catch (MissingGradeException e) {
            throw new InvalidDataException("Grades are missing ", e);
        }

        int count = 0;
        for (double gpa : gpaList)
            if (gpa >= lower && gpa <= higher)
                count++;

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < gpaList.length; i++)
            if (gpaList[i] >= lower && gpaList[i] <= higher)
                result[index++] = studentIdList[i];


        return result;
    }
}
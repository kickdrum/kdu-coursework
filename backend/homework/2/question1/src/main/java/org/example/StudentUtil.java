package org.example;

public class StudentUtil {
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        if (studentIdList == null || studentsGrades == null || studentIdList.length != studentsGrades.length) {
            return null; // Parameter validation failed
        }

        double[] result = new double[studentIdList.length];

        for (int i = 0; i < studentIdList.length; i++) {
            int totalPoints = 0;
            int totalCourses = studentsGrades[i].length;

            for (char grade : studentsGrades[i]) {
                switch (grade) {
                    case 'A':
                        totalPoints += 4;
                        break;
                    case 'B':
                        totalPoints += 3;
                        break;
                    case 'C':
                        totalPoints += 2;
                        break;
                    // Add more cases if needed for other grades
                }
            }

            result[i] = (double) totalPoints / totalCourses;
        }

        return result;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        if (lower < 0 || higher < 0 || lower > higher || studentIdList == null || studentsGrades == null || studentIdList.length != studentsGrades.length) {
            return null; // Parameter validation failed
        }

        double[] gpas = calculateGPA(studentIdList, studentsGrades);

        if (gpas == null) {
            return null; // GPA calculation failed, return null
        }

        int count = 0;
        for (double gpa : gpas) {
            if (gpa >= lower && gpa <= higher) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < gpas.length; i++) {
            if (gpas[i] >= lower && gpas[i] <= higher) {
                result[index++] = studentIdList[i];
            }
        }

        return result;
    }
}

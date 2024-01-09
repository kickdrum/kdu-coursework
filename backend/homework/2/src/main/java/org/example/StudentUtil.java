package org.example;

import java.util.*;
public class StudentUtil {
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        double[] gpaArray = new double[studentIdList.length];

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
                }
            }

            gpaArray[i] = (double) totalPoints / totalCourses;
        }

        return gpaArray;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {

        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }

        double[] gpaArray = calculateGPA(studentIdList, studentsGrades);

        int count = 0;
        for (double gpa : gpaArray) {
            if (gpa >= lower && gpa <= higher) {
                count++;
            }
        }

        int[] resultArray = new int[count];
        int index = 0;
        for (int i = 0; i < studentIdList.length; i++) {
            if (gpaArray[i] >= lower && gpaArray[i] <= higher) {
                resultArray[index++] = studentIdList[i];
            }
        }

        return resultArray;
    }
}


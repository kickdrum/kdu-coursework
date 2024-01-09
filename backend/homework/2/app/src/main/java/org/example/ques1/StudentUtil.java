package org.example.ques1;

import org.example.Log;

import java.util.Scanner;

public class StudentUtil {
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        int numberOfStudents = studentIdList.length;
        double[] studentsGPA = new double[numberOfStudents];
        for (int student = 0; student < numberOfStudents; student++) {
            double sum = 0;
            for (int grade = 0; grade < studentsGrades[student].length; grade++) {
                switch (studentsGrades[student][grade]) {
                    case 'A': {
                        sum += 4.0;
                        break;
                    }
                    case 'B': {
                        sum += 3.0;
                        break;
                    }
                    case 'C': {
                        sum += 2.0;
                        break;
                    }
                    default: {
                        sum += 0.0;
                    }
                }
            }
            studentsGPA[student] = sum / (studentsGrades[student].length);
        }
        return studentsGPA;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        if (lower > higher || lower < 0 || lower > 4 || higher > 4 || higher < 0 || studentIdList == null || studentsGrades == null) {
            int[] students = new int[0];
            return students;
        }
        double[] studentsGPA = calculateGPA(studentIdList, studentsGrades);
        int numberOfStudents = studentIdList.length;
        int[] students = new int[numberOfStudents];

        for (int student = 0; student < numberOfStudents; student++) {
            if (studentsGPA[student] >= lower && studentsGPA[student] <= higher) {
                students[student] = studentIdList[student];
            } else {
                students[student] = -1;
            }
        }
        return students;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Log.logger.info("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        int[] studentIdList = new int[numberOfStudents];
        char[][] studentsGrades = new char[numberOfStudents][];
        for (int student = 0; student < numberOfStudents; student++) {
            Log.logger.info("Enter new student id: ");
            studentIdList[student] = scanner.nextInt();
            Log.logger.info("Enter number of Grades for student with ID {}: ", studentIdList[student]);
            int numberOfGrades = scanner.nextInt();
            studentsGrades[student] = new char[numberOfGrades];
            Log.logger.info("Enter space separated grades for student with ID {}: ", studentIdList[student]);
            for (int grade = 0; grade < numberOfGrades; grade++) {
                studentsGrades[student][grade] = scanner.next().charAt(0);
                if (studentsGrades[student][grade] != 'A' && studentsGrades[student][grade] != 'B' && studentsGrades[student][grade] != 'C') {
                    Log.logger.info("Invalid grade entered. Please enter again: ");
                    grade--;
                }
            }
        }

        double[] studentsGPA = calculateGPA(studentIdList, studentsGrades);
        for (int i = 0; i < studentsGPA.length; i++) {
            Log.logger.info("GPA of student with ID {} is {}\n", studentIdList[i], studentsGPA[i]);
        }
        Log.logger.info("Enter lower limit of GPA: ");
        double lower = scanner.nextDouble();
        Log.logger.info("Enter higher limit of GPA: ");
        double higher = scanner.nextDouble();
        int[] students = getStudentsByGPA(lower, higher, studentIdList, studentsGrades);
        if (students == null) {
            Log.logger.info("No record matched.");
        } else {
            Log.logger.info("ID of students with GPA between {} and {} are: ", lower, higher);
            for (int student : students) {
                if (student == -1) {
                    continue;
                }
                Log.logger.info(student);
            }

        }

    }
}

package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sentiment.analysis.SentimentAnalyzer;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(SentimentAnalyzer.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        logger.info("Enter lower GPA range: ");
        double lower = scanner.nextDouble();

        logger.info("Enter higher GPA range: ");
        double higher = scanner.nextDouble();

        logger.info("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        int[] studentIdList = new int[numberOfStudents];
        char[][] studentsGrades = new char[numberOfStudents][];


        for (int i = 0; i < numberOfStudents; i++) {
            logger.info("Enter student ID for student " + (i + 1) + ": ");
            studentIdList[i] = scanner.nextInt();

            logger.info("Enter the number of courses for student " + (i + 1) + ": ");
            int numberOfCourses = scanner.nextInt();

            studentsGrades[i] = new char[numberOfCourses];

            logger.info("Enter grades for student: ");
            for (int j = 0; j < numberOfCourses; j++) {
                studentsGrades[i][j] = scanner.next().charAt(0);
            }
        }

        scanner.close();

        double[] gpaArray = StudentUtil.calculateGPA(studentIdList, studentsGrades);

        logger.info("GPAs: "+ Arrays.toString(gpaArray));

        int[] resultArray = StudentUtil.getStudentsByGPA(lower, higher, studentIdList, studentsGrades);


        if (resultArray == null) {
            logger.warn("\nWrong Information");
        } else {
            logger.info("StudentIDs: "+ Arrays.toString(resultArray));
        }
    }
}
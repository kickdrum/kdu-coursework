package org.example;

import org.example.StudentUtil;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoggerClass.getLoggerOutput().info("Enter lower range value: ");
        double lower = scanner.nextDouble();

        LoggerClass.getLoggerOutput().info("Enter higher range value: ");
        double higher = scanner.nextDouble();

        LoggerClass.getLoggerOutput().info("Enter size of student id list ");
        int sizeList = scanner.nextInt();

        int[] studentIdList = new int[sizeList];

        for(int i = 0; i < sizeList; i++)
        {
            LoggerClass.getLoggerOutput().info("Enter student id");
            studentIdList[i] = scanner.nextInt();
        }

        scanner.nextLine();

        char[][] studentsGrades = new char[sizeList][];
        for (int i = 0; i < sizeList; i++) {
            LoggerClass.getLoggerOutput().info("Enter grades for student with ID " + studentIdList[i] + ":");
            String gradesInput = scanner.nextLine();
            studentsGrades[i] = gradesInput.toCharArray();
        }

//        double lower = 3.2;
//        double higher = 3.5;
//        int[] studentIdList = {1001, 1002};
//        char[][] studentsGrades = { { 'A', 'A', 'A', 'B' }, { 'A', 'B', 'B' } };
        int[] answer = StudentUtil.getStudentsByGPA(lower, higher, studentIdList, studentsGrades);
        LoggerClass.getLoggerOutput().info(Arrays.toString(answer));
    }
}
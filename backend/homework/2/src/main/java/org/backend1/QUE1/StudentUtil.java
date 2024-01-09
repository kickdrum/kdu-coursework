package org.backend1.QUE1;
import org.backend1.QUE2.SentimentAnalyzer;

import java.util.*;
import java.util.logging.Logger;

public class StudentUtil {

    private static final Logger LOGGER = Logger.getLogger(SentimentAnalyzer.class.getName());


    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades){
        if(studentIdList == null || studentsGrades == null || studentIdList.length != studentsGrades.length)
            return null;

        double[] var = new double[studentIdList.length];

        for(int i = 0; i < studentIdList.length; i++){
            int scored = 0;
            int totalcourses = studentsGrades[i].length;

            for(char grades : studentsGrades[i]){
                switch(grades){
                    case 'A': scored += 4;
                              break;

                    case 'B': scored += 3;
                              break;

                    case 'C': scored += 2;
                              break;
                }
            }

            var[i] = (double) scored / totalcourses;
        }
        return var;
    }


    public static int[] getStudentsbyGPA(double lower, double  higher, int[] studentIdList, char[][] studentGrades)
    {
        if(lower > higher || lower < 0 || higher < 0 || studentGrades.length != studentIdList.length)
        {
            return null;
        }

        double[] gpa_avg = calculateGPA(studentIdList, studentGrades);
        int cnt = 0;
        for(double val : gpa_avg){
            if(val >= lower && val <= higher) cnt++;
        }

        int[] list = new int[cnt];
        int idx = 0;
        for(int i = 0; i < gpa_avg.length; i++){
            if(gpa_avg[i] >= lower && gpa_avg[i] <= higher){
                list[idx++] = studentIdList[i];
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.print("Enter the number of students (n): ");
        LOGGER.info("Enter the number of students (n): ");
        int n = scanner.nextInt();

        int[] studentIdList = new int[n];
//        System.out.println("Enter student IDs:");
        LOGGER.info("Enter student IDs:");
        for (int i = 0; i < n; i++) {
            studentIdList[i] = scanner.nextInt();
        }

        char[][] studentsGrades = new char[n][];
//        System.out.println("Enter students' grades:");
        LOGGER.info("Enter students' grades:");
        for (int i = 0; i < n; i++) {

//            System.out.print("Student " + studentIdList[i] + ": ");
            LOGGER.info("Student " + studentIdList[i] + ": ");
            String gradesInput = scanner.next();
            studentsGrades[i] = gradesInput.toCharArray();
        }


        double[] gpas = calculateGPA(studentIdList, studentsGrades);
//        System.out.println("GPAs: " + Arrays.toString(gpas));
        LOGGER.info("GPAs: " + Arrays.toString(gpas));

//        System.out.print("Enter the lower number: ");
        LOGGER.info("Enter the lower number: ");
        double lower = scanner.nextDouble();

//        System.out.print("Enter the high number: ");
        double higher = scanner.nextDouble();
        LOGGER.info("Enter the high number: ");

        int[] result = getStudentsbyGPA(lower, higher, studentIdList, studentsGrades);
        System.out.println("Students with GPA between " + lower + " and " + higher + "is : " + Arrays.toString(result));
        LOGGER.info("Students with GPA between " + lower + " and " + higher + "is : " + Arrays.toString(result));
    }

}

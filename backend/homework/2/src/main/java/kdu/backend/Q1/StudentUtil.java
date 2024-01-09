package kdu.backend.Q1;
import java.util.*;
import java.util.logging.Logger;

public class StudentUtil {

    private static final Logger logger = Logger.getLogger(StudentUtil.class.getName());

    public static double[] calculateGPA(int[] studentList, char[][] studentsGrades) {
        int size = studentList.length;
        double[] studentGPA = new double[size];

        for (int i = 0; i < size; i++) {
            int credits = 0;
            int courses = studentsGrades[i].length;
            char[] ch = studentsGrades[i];
            for (int j = 0; j < courses; j++) {
                if (ch[j] == 'A') {
                    credits += 4;
                } else if (ch[j] == 'B') {
                    credits += 3;
                } else if (ch[j] == 'C') {
                    credits += 2;
                }
            }
            studentGPA[i] = (double)credits / courses;
        }
        return studentGPA;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        double[] studentListGPA = calculateGPA(studentIdList, studentsGrades);

        if(lower<0 || higher<0 || higher<lower){
            return null;
        }

        int cnt = 0;
        int size = studentListGPA.length;

        for (int i = 0; i < size; i++) {
            if (studentListGPA[i] >= lower && studentListGPA[i] <= higher) {
                cnt++;
            }
        }
        int[] answerInfo = new int[cnt];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (studentListGPA[i] >= lower && studentListGPA[i] <= higher) {
                answerInfo[j++] = studentIdList[i];
            }
        }
        return answerInfo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        logger.info("Enter the lower and upper range");

        double lower = sc.nextDouble();
        double higher = sc.nextDouble();

        logger.info( "Enter the number of students: ");
        int numStudents = sc.nextInt();

        int[] studentIdList = new int[numStudents];
        char[][] studentsGrades = new char[numStudents][];

        for (int i = 0; i < numStudents; i++) {
            logger.info("Enter student ID for student " + (i + 1) + ": ");
            studentIdList[i] = sc.nextInt();

            logger.info("Number of courses this student has : ");
            int numOfGrades = sc.nextInt();
            studentsGrades[i] = new char[numOfGrades];

            logger.info("Enter grades for each course for student " + (i + 1) + " (A, B, C): ");
            for (int j = 0; j < numOfGrades; j++) {
                studentsGrades[i][j] = sc.next().charAt(0);
            }
        }

        // Using the getStudentsByGPA method // perform parameter validation. Return null if passed parameters are not valid
        int[] selectStudents = getStudentsByGPA(lower, higher, studentIdList, studentsGrades);

        if (selectStudents == null) {
            logger.info("Invalid inputs");
        } else if (selectStudents.length == 0) {
            logger.info( "Number of students with the required range are 0");
        } else {
            logger.info("Students with GPA between " + lower + " and " + higher + "are : ");
            for (int studentId : selectStudents) {
                logger.info( String.valueOf(studentId));
            }
        }
    }
}

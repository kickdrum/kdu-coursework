package org.example;


public class Main {
    public static void main(String[] args) {

        int[] studentList = {1001,1002};
        char[][] studentsGrades = {{'A', 'A', 'A', 'B'}, {'A', 'B', 'B'}};

        Logging logging = new Logging();
        int[] ans = StudentUtil.getStudentsByGPA(3.2, 3.5, studentList, studentsGrades);

        if (ans != null) {
            StringBuilder stringBuilder = new StringBuilder("Students in the range : ");
            for (int studentId : ans) {
                stringBuilder.append(studentId);
                stringBuilder.append(" ");
            }
            logging.logString(stringBuilder);
        } else {
            logging.logString("No students found within the specified GPA range.");
        }
    }
}

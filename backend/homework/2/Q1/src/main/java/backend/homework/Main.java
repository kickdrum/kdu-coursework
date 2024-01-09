package backend.homework;



public class Main {

    public static void main(String[] args) {
        int[] studentIdList = {1001, 1002};
        char[][] studentsGrades = {
                {'A', 'A', 'A', 'B'},
                {'A', 'B', 'B'}
        };

        // Calling Studentutil to calculate GPAs for all students in the List
        double[] gpas = StudentUtil.calculateGPA(studentIdList, studentsGrades);

        // Printing the calculated GPAs
        for (int i = 0; i < gpas.length; i++) {
            System.out.println("Student ID: " + studentIdList[i] + ", GPA: " + gpas[i]);
        }

        // Get students with GPA between 3.2 and 3.5
        int[] selectedStudents = StudentUtil.getStudentsByGPA(3.2, 3.5, studentIdList, studentsGrades);

        // Print the selected students
        if (selectedStudents != null) { // Check for null due to parameter validation
            System.out.println("\nStudents with GPA between 3.2 and 3.5:");
            for (int studentId : selectedStudents) {
                System.out.println(studentId);
            }
        }
    }
}

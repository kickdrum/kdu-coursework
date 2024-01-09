package backend.homework;
/**
 * Provides utility methods for working with student data, such as calculating GPAs and filtering students based on GPA ranges.
 *
 * @author [Your Name]
 */
public class StudentUtil {

    /**
     * Calculates the GPAs for a list of students based on their grades.
     *
     * @param studentIdList an array of student IDs
     * @param studentsGrades a 2D array of grades, where each inner array represents the grades for a student
     * @return an array of GPAs, where the index of each GPA corresponds to the index of the student in the input arrays
     */
    public static double[] calculateGPA(int[] studentIdList, char[][]
            studentsGrades) {
        int studentsCount = studentIdList.length;
        double[] studentsGpa = new double[studentsCount];
        for (int i = 0; i < studentsCount; i++) {
            double totalPoints = 0;
            int coursesCount = studentsGrades[i].length;
            for (char grade : studentsGrades[i]) {
                int points = gradeToPointsUtil(grade);
                totalPoints += points;
            }
            studentsGpa[i] = totalPoints / coursesCount;
        }
            return studentsGpa;
        }

    /**
     * Filters students based on a specified GPA range and returns their IDs.
     *
     * @param lower the lower bound of the GPA range (inclusive)
     * @param higher the upper bound of the GPA range (inclusive)
     * @param studentIdList an array of student IDs
     * @param studentsGrades a 2D array of grades, where each inner array represents the grades for a student
     * @return an array of student IDs whose GPAs fall within the specified range, or null if the input is invalid
     */
    public static int[] getStudentsByGPA(double lower, double higher, int[]
            studentIdList, char[][] studentsGrades) {
        if (lower < 0 || higher < 0 || lower > higher) {
            return null; // Invalid input
        }
        double[] studentGpa = calculateGPA(studentIdList,studentsGrades);
        int count=0;
        for (double gpa : studentGpa) {
            if (gpa >= lower && gpa <= higher) {
                count++;
            }
        }
        int[] selectedStudents = new int[count];
        int index=0;

        if (count > 0) {
            for (int i = 0; i < studentGpa.length; i++) {
                if (studentGpa[i] >= lower && studentGpa[i] <= higher) {
                    selectedStudents[index++] = studentIdList[i];
                }
            }
        }
        else {
            return new int[0];
        }


        return selectedStudents;
    }

    /**
     * Converts a letter grade to its corresponding numerical points value.
     *
     * @param grade the letter grade to convert
     * @return the numerical points value (4 for A, 3 for B, 2 for C, 0 for invalid grades)
     */
        private static int gradeToPointsUtil ( char grade){
            switch (grade) {
                case 'A':
                    return 4;
                case 'B':
                    return 3;
                case 'C':
                    return 2;
                default:
                    return 0; // In case of invalid grade input
            }
        }

}

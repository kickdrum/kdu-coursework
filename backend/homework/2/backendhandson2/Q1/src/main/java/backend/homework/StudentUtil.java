package backend.homework;

public class StudentUtil {
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

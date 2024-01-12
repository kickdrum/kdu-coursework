package kdu.homework;

public class StudentUtil {
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {

        double[] gpaList = new double[studentIdList.length];
        Logs logger = new Logs();

        try {

            if(studentIdList.length != studentsGrades.length){

                String message =  "studentIdList & studentsGrades are out-of-sync. studentIdList.length: " + studentIdList.length + ", studentsGrades.length: " + studentsGrades.length;
                throw new IllegalArgumentException(message);
            }


            for (int i = 0; i < studentsGrades.length; i++) {
                double gpa = 0.0;
                for (int j = 0; j < studentsGrades[i].length; j++) {
                    if (studentsGrades[i][j] == 'A') {
                        gpa += 4.0;
                    } else if (studentsGrades[i][j] == 'B') {
                        gpa += 3.0;
                    } else if (studentsGrades[i][j] == 'C') {
                        gpa += 2.0;
                    } else if (studentsGrades[i][j] == ' ') {
                        //throwing checked exception MissingGradeException with student ID
                        throw new MissingGradeException(studentIdList[i]);
                    }
                }

                gpaList[i] = gpa/studentsGrades[i].length;
            }


        }
        catch(IllegalArgumentException illegalArgumentException){
            logger.console(illegalArgumentException.toString());
        }
        catch(MissingGradeException missingGradeException){
            logger.console(missingGradeException.toString());
            throw new InvalidDataException("InvalidDataException: " + missingGradeException.toString());
        }

        return gpaList;
    }


    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {

    // GPAs must be computed only after all students have received grades.

        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }

        double[] gpaList = new double[studentIdList.length];
        // Your code: catch MissingGradeException and re-throw runtime exception InvalidDataException initialized with the cause MissingGradeException

        try {

            gpaList = calculateGPA(studentIdList, studentsGrades);


            int count = 0;
            for (double gpa : gpaList) {
                if (gpa >= lower && gpa <= higher) {
                    count++;
                }
            }

            int[] result = new int[count];
            int index = 0;
            for (int i = 0; i < gpaList.length; i++) {
                if (gpaList[i] >= lower && gpaList[i] <= higher) {
                    result[index++] = studentIdList[i];
                }
            }

            return result;
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }


}

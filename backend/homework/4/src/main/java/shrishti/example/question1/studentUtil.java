package shrishti.example.question1;
import shrishti.example.Logger.logger;

import java.util.*;


public class studentUtil {
    public static int mapGradeToScore(char grade){
        if(grade=='A'){
            return 4;
        }
        if(grade == 'B'){
            return 3;
        }
        if(grade == 'C'){
            return 2;
        }
        else if(grade == ' '){
          return -1;
        }
            return 0;
    }
    public static double[] calculateGPA (int[] studentList, char[][]studentGrades) throws MissingGradeException {
        if(studentList.length != studentGrades.length){
            throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length:" + studentList.length + ", studentGrades.length:" + studentGrades.length);
        }
        int totalStudents= studentList.length;
        double[] gradeArray=new double[totalStudents];
        double totalGrade=0;
        for(int i=0;i<totalStudents;i++){
            totalGrade=0;
            for(int j=0;j<studentGrades[i].length;j++){
                int num = mapGradeToScore(studentGrades[i][j]);
                if(num==-1){
                    throw new MissingGradeException(studentList[i]);
                }
                totalGrade=num;
            }
            gradeArray[i]=totalGrade/studentGrades[i].length;
        }
        return  gradeArray;

    }

    public static int[] getStudentsByGPA(double lower, double higher, int[]
            studentIdList, char[][] studentsGrades) {
        double[] finalGrades = new double[0];
        try {
            finalGrades = calculateGPA(studentIdList,studentsGrades);
        } catch (MissingGradeException e) {

            throw new InvalidDataException("Student grades missing", e);
        }
        int count=0;
        for (double finalGrade : finalGrades) {
            if (finalGrade >= lower && finalGrade < higher) {
                count++;
            }
        }
        int[] studentInRange= new int[count];
        int index = 0;
        for(int i=0;i<finalGrades.length;i++){
            if(finalGrades[i]>=lower && finalGrades[i]<=higher){
                studentInRange[index]=studentIdList[i];
                index++;
            }
        }
        return studentInRange ;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int[] studentIdList = {1001,1002,1003};
        char[][] studentsGrades ={{'A','A','B','A'},{'A','B','C'}, {'A','C'}};
        System.out.println("Enter the lower and higher limit for the GPA:");
        double lower= scanner.nextDouble();
        double higher = scanner.nextDouble();
        int[] idList = getStudentsByGPA(lower,higher,studentIdList, studentsGrades);
        logger.printLogger("This list is of ");
        for(int i:idList){
            logger.printLogger("Filtered Students: " + Integer.toString(i));
        }
    }

}


// size of both arrays should be same
//


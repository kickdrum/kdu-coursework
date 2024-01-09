package shrishti.example.q1;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentUtil {
    static Logger log= LoggerFactory.getLogger(Logger.class);
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
        else
            return 0;
    }
    public static double[] calculateGPA(int[] studentList, char[][]studentGrades){
        int totalStudents= studentList.length;
        double[] GradeArray=new double[totalStudents];
        double totalGrade=0;
        for(int i=0;i<totalStudents;i++){
            totalGrade=0;
            for(int j=0;j<studentGrades[i].length;j++){
                int num = mapGradeToScore(studentGrades[i][j]);
                totalGrade=num;
            }
            GradeArray[i]=totalGrade/studentGrades[i].length;
           // System.out.println((studentGrades[0]));
        }
        return  GradeArray;

    }

    public static int[] getStudentsByGPA(double lower, double higher, int[]
            studentIdList, char[][] studentsGrades) {
        double[] finalGrades = calculateGPA(studentIdList,studentsGrades);
        int count=0;
        for (double finalGrade : finalGrades) {
            if (finalGrade >= lower && finalGrade < higher) {
                count++;
            }
        }
        int[] StudentInRange= new int[count];
        int index = 0;
        for(int i=0;i<finalGrades.length;i++){
            if(finalGrades[i]>=lower && finalGrades[i]<=higher){
                StudentInRange[index]=studentIdList[i];
                index++;
            }
        }
        return StudentInRange ;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int studentIdList[]= {1001,1002,1003};
        char studentsGrades[][]={{'A','A','B','A'},{'A','B','C'}, {'A','C'}};
        System.out.println("Enter the lower and higher limit for the GPA:");
        double lower= scanner.nextDouble();
        double higher = scanner.nextDouble();
        int idList[] = getStudentsByGPA(lower,higher,studentIdList, studentsGrades);
                System.out.println("This list is : ");
                for(int i:idList){
                    System.out.println("Filtered Students: " + i);
                }
    }

}




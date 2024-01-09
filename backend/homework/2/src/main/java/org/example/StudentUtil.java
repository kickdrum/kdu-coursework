package org.example;

import java.lang.invoke.VarHandle;
import java.time.temporal.ValueRange;

public class StudentUtil {
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        double[] gpa=new double[studentIdList.length];
        for(int i=0;i<studentsGrades.length;i++){
            double sum=0;
            for(int j=0;j<studentsGrades[i].length;j++){
//                sum+=studentsGrades[i][j]-'A';
                if(studentsGrades[i][j]=='A')
                    sum+=4;
                else if(studentsGrades[i][j]=='B')
                    sum+=3;
                else
                    sum+=2;
            }
            int sz=studentsGrades[i].length;
            gpa[i]=sum/sz;
        }
        return gpa;

    }
    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        // perform parameter validation. Return null if passed parameters ar not valid
        int[] validGpa=new int[0];
        if(lower>higher)
            return validGpa;

        // invoke calculateGPA
        double[] gpa =calculateGPA(studentIdList,studentsGrades);
        int ind=0;
        for(int i=0;i<studentIdList.length;i++){
            if(gpa[i]>=lower && gpa[i]<=higher){
                int sz= validGpa.length;
                int[] newValidGpa = new int[sz+1];
                newValidGpa[ind]=studentIdList[i];
                ind++;
                validGpa=newValidGpa;
            }
        }

        // construct the result array and return it. You would need an extra for loop to compute the size of the resulting array
        return validGpa;
    }
    public static void main(String[] args){
        int[] studentIdList = {1001, 1002};
        char[][] studentsGrades = { { 'A', 'A', 'A', 'B' },{ 'A', 'B', 'B' }};
        int[] ans=getStudentsByGPA(3.2,3.5,studentIdList,studentsGrades);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}

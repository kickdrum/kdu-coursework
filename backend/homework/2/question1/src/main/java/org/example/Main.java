package org.example;
import org.example.StudentUtil;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        StudentUtil sc = new StudentUtil();
        int []sid={1001,1002};
        char[][] grade = { { 'A', 'A', 'A', 'B' }, { 'A', 'B', 'B' } };
        double[] d = sc.calculateGPA( sid,grade);

        int[] ans = sc.getStudentsByGPA(3.2,3.5,sid,grade);
        for(int i=0;i< ans.length;i++) {
            System.out.println(ans[i]);
        }

    }
}
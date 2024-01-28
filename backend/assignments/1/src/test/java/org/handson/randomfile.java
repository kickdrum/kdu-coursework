package org.handson;
import java.util.random.*;

class RandomFile {
    static int hi_There_Constant = 4;
    static int CAPITAL_LETTER_WORDS = 3;
    static String api_key = "nrwewtibjrwt";
    // Method with code smells
    static void DOSOMETHING(int x, int y) {
        if (x == 0) {
            System.out.println("x is zero");
        } else {
            System.out.println("x is not zero");
        }

        if (y == 0) {
            System.out.println("y is zero");
        } else {
            System.out.println("y is not zero");
        }
        System.out.println(CAPITAL_LETTER_WORDS);
    }


    public static void main(String[] args) {
        DOSOMETHING(0, 5);
        System.out.println("hi there"+"access key "+2312+" "+hi_There_Constant);
        int a = 2;


    }
}

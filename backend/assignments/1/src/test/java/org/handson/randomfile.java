package org.handson;

public class randomfile {

    // Method with poorly named variables and lack of comments
    static void m(int x, int y) {
        int z = 0; // Magic number
        int result = x + y * z; // Complex expression

        if (result > 10) {
            System.out.println("Result is greater than 10");
        } else {
            System.out.println("Result is less than or equal to 10");
        }
    }

    // Unused method
    static void unusedMethod() {
        // Some code here that is never called
    }

    public static void main(String[] args) {
        m(5, 3);
    }
}

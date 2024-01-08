package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInputHandler {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final Logger inputLogger = new Logger();

    public int readId() {
        try {
            System.out.print("Enter Student Id: ");
            return new Scanner(System.in).nextInt();
        } catch (NumberFormatException e) {
            inputLogger.errorLog("Invalid Id!",e);
            return -1;
        }
    }
    public String readName() {
        try {
            System.out.print("Enter your name: ");
            return reader.readLine().trim();
        } catch (IOException e) {
            inputLogger.errorLog("Invalid name!",e);
        }
        return "";
    }

    public int readAge() {
        while (true) {
            try {
                System.out.print("Enter your age: ");
                int age = Integer.parseInt(reader.readLine());
                if (age >= 0 && age <= 150) {
                    return age;
                } else {
                    System.out.println("Please enter a valid age between 0 and 150.");
                }
            } catch (IOException | NumberFormatException e) {
                inputLogger.errorLog("Invalid age!",e);
                return -1;
            }
        }
    }

    public char readGrades() {
        while (true) {
            try {
                System.out.print("Enter your grade [A-F]: ");
                char gradeChar = (char)reader.read();

                if (gradeChar >= 'A' && gradeChar <= 'F') { // Assuming a reasonable grades range
                    return gradeChar;
                } else {
                    System.out.println("Please enter valid grade [A-F].");
                }
            } catch (IOException | NumberFormatException e) {
                inputLogger.errorLog("Invalid age!",e);
                return '0';
            }
        }
    }

}

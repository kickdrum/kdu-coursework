package javafundamentals1;

import LogBack.LogBack;
import javafundamentals1.StudentRepository.StudentRepository;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        StudentRepository obj = new StudentRepository();
        System.out.println("Welcome to the app");
        LogBack.slf4jLogger.debug("App started");
        while (true) {
            System.out.println("Enter 1 for adding the student");
            System.out.println("Enter 2 for retrieving the student");
            System.out.println("Enter 3 for updating based on id of Student");
            System.out.println("Enter 4 for updating based on name of Student");
            System.out.println("Enter 5 for quitting");
            int n = scn.nextInt();
            if (n == 1) {
                LogBack.slf4jLogger.debug("New Student added");
                obj.addStudent();
            } else if (n == 2) {
                System.out.println("Enter id of student");
                int id = scn.nextInt();
                obj.retrieve(id);
                LogBack.slf4jLogger.debug("Student with id:"+id+"retrieved");
            } else if (n == 3) {
                System.out.println("Enter id of student");
                int id = scn.nextInt();
                obj.update(id);
                LogBack.slf4jLogger.debug("Student with id:"+id+"retrieved");
            } else if (n == 4) {
                scn.nextLine();
                System.out.println("Enter name of student");
                String name = scn.nextLine();
                obj.update(name);
                LogBack.slf4jLogger.debug("Student with id:"+name+"retrieved");
            } else {
                LogBack.slf4jLogger.debug("Exiting App");
                System.out.println("Welcome back soon !!");
                break;
            }
        }


    }
}
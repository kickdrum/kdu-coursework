package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        StudentReposittory repository = new StudentReposittory(1);
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Number Student want to Add: ");
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Id:");
            int id = scn.nextInt();
            System.out.println("Enter Name:");
            String name = scn.next();
            System.out.println("Enter Age:");
            int age = scn.nextInt();
            System.out.println("Enter Grade:");
            int grade = scn.nextInt();
            Student newStudent1 = new Student(id, name, age, grade);
            repository.addStudent(newStudent1);
            logger.fatal("Added student: {}", newStudent1.getName());
        }

        System.out.println("Enter number details you want Retrive:");
        int n1= scn.nextInt();
        for(int i=0;i<n1;i++){
            System.out.println("Enter the id Which you want retrive:");
            int v = scn.nextInt();
            Student retrievedStudent = repository.getStudentById(v);
            if (retrievedStudent != null) {
                logger.fatal("Retrieved Student: {}", retrievedStudent.getName());
            }
        }


    }
}
package org.example;





//package com.example.app;
//
//import com.example.core.Student;
//import com.example.data.StudentRepository;
//import com.example.logging.LoggerService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        LogbackHello loggerService = new LogbackHello();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select operation:");
            System.out.println("1. Add a student");
            System.out.println("2. Retrieve a student");
            System.out.println("3. Update a student");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a student
                    System.out.println("Enter student details:");
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Grade: ");
                    String grade = scanner.nextLine();

                    Student newStudent = new Student(id, name, age, grade);
                    studentRepository.addStudent(newStudent);
                    loggerService.logStudentAddition(newStudent);
                    break;

                case 2:
                    // Retrieve a student
                    System.out.println("Enter student ID to retrieve:");
                    int studentIdToRetrieve = scanner.nextInt();
                    Student retrievedStudent = studentRepository.retrieveStudent(studentIdToRetrieve);
                    if (retrievedStudent != null) {
                        loggerService.logStudentRetrieval(studentIdToRetrieve);
                        System.out.println("Retrieved Student: " + retrievedStudent.getName());
                    }
                    break;

                case 3:
                    // Update a student
                    System.out.println("Enter student ID to update:");
                    int studentIdToUpdate = scanner.nextInt();
                    Student studentToUpdate = studentRepository. retrieveStudent(studentIdToUpdate);
                    if (studentToUpdate != null) {
                        System.out.println("Enter updated details:");
                        System.out.print("New Age: ");
                        int newAge = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("New Grade: ");
                        String newGrade = scanner.nextLine();

                        studentToUpdate.setAge(newAge);
                        studentToUpdate.setGrade(newGrade);
                        studentRepository.updateStudent(studentToUpdate);
                        loggerService.logStudentUpdate(studentToUpdate);
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting application.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

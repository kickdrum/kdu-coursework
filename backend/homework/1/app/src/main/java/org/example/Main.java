package org.example;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Main {
    private static final Logger loggers = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        LoggingUtil logger = new LoggingUtil();
        Scanner scanner = new Scanner(System.in);
        StudentRepository repository = new StudentRepository();

        loggers.info("Welcome! Enter the corresponding number for the action:");

        boolean running = true;
        while (running) {
            loggers.info("1. Add Student         2. Retrieve by ID");
            loggers.info("3. Retrieve by Name    4. Update Student");
            loggers.info("5. Exit");
            loggers.info("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    loggers.info("Enter student ID:");
                    int id = scanner.nextInt();

                    loggers.info("Enter student name:");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    loggers.info("Enter student age:");
                    int age = scanner.nextInt();

                    loggers.info("Enter student grade:");
                    String grade = scanner.next();

                    Student student = new Student(id, name, age, grade);
                    repository.addStudent(student);
                    logger.addLog(student);
                    break;
                case 2:
                    loggers.info("Enter student ID to retrieve:");
                    int idt = scanner.nextInt();

                    Student retrievedStudent = repository.getStudent(idt);
                    logger.getstuid(retrievedStudent);
                    break;
                case 3:
                    loggers.info("Enter student name to retrieve:");
                    String names = scanner.nextLine().toLowerCase();

                    Student retrievedStudent1 = repository.getStudent(names);
                    logger.getstuname(retrievedStudent1);
                    break;
                case 4:
                    loggers.info("Enter student ID to update:");
                    int ida = scanner.nextInt();

                    Student existingStudent = repository.getStudent(ida);
                    if (existingStudent != null) {
                        loggers.info("Enter updated student name:");
                        scanner.nextLine();
                        String name1 = scanner.nextLine();

                        loggers.info("Enter updated student age:");
                        int age1 = scanner.nextInt();

                        loggers.info("Enter updated student grade:");
                        String grade1 = scanner.next();

                        Student updatedStudent = new Student(ida, name1, age1, grade1);
                        if (repository.update(updatedStudent)) {
                            loggers.info("Student information updated: " + updatedStudent);
                            logger.updlog(updatedStudent);
                        } else {
                            loggers.info("Failed to update student information.");
                        }

                    } else {
                        loggers.info("Student not found for ID: " + ida);
                    }
                    break;
                case 5:
                    running = false;
                    loggers.info("Exiting the application.");
                    break;
                default:
                    loggers.info("Invalid choice. Please enter a valid number (1, 2, 3, 4, 5).");
            }
        }
    }
}
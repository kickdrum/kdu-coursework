package org.example;

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final StudentRepository studentRepository = new StudentRepository();
    private static final Scanner scanner = new Scanner(System.in);

    static {
        initializeLogger();
    }

    public static void main(String[] args) {
        boolean exit = false;

        do {
            System.out.println("Choose an operation:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. Retrieve Student Information");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addStudentFromUserInput();
                    break;
                case 2:
                    updateStudentInformationFromUserInput();
                    break;
                case 3:
                    retrieveStudentFromUserInput();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }

        } while (!exit);

        scanner.close();


        for (Handler handler : LOGGER.getHandlers()) {
            handler.close();
        }
    }


    private static void initializeLogger() {
           try {
            // Create a file handler for logging
            Handler fileHandler = new FileHandler("log.txt");
            fileHandler.setFormatter(new SimpleFormatter());
           LOGGER.addHandler(fileHandler);

            // Set the logger level (you can adjust the level based on your needs)
            LOGGER.setLevel(Level.ALL);

            // Log a message to indicate that the logger has been initialized
            LOGGER.info("Logger initialized successfully.");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error initializing logger", e);
       }
    }

    private static void addStudentFromUserInput() {
        try {
            LOGGER.info("Enter student details:");

            LOGGER.info("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            LOGGER.info("Name: ");
            String name = scanner.nextLine();

            LOGGER.info("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            LOGGER.info("Grade: ");
            String grade = scanner.nextLine();

            // Create a new student and add it to the repository
            Student newStudent = new Student(id, name, age, grade);
            studentRepository.addStudentDetails(newStudent);

            LOGGER.info("Added student: " + newStudent.get_name() + ", ID: " + newStudent.get_ID());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error adding student", e);
        }
    }

    private static void updateStudentInformationFromUserInput() {
        try {
            LOGGER.info("Enter the ID of the student to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            LOGGER.info("Enter new information:");

            LOGGER.info("Name: ");
            String name = scanner.nextLine();

            LOGGER.info("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            LOGGER.info("Grade: ");
            String grade = scanner.nextLine();

            // Update the information for the specified student in the repository
            studentRepository.updateStudentDetails(id, name, age, grade);

            LOGGER.info("Updated information for student with ID " + id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error updating student information", e);
        }
    }

    private static void retrieveStudentFromUserInput() {
        try {
            LOGGER.info("Enter the ID of the student to retrieve: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Retrieve and display student details from the repository
            Student retrievedStudent = studentRepository.retrieveStudentDetails(id);
            if (retrievedStudent != null) {
                LOGGER.info("Retrieved student details:");
                LOGGER.info("ID: " + retrievedStudent.get_ID());
                LOGGER.info("Name: " + retrievedStudent.get_name());
                LOGGER.info("Age: " + retrievedStudent.get_age());
                LOGGER.info("Grade: " + retrievedStudent.get_grade());
            } else {
                LOGGER.warning("Student not found.");
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error retrieving student information", e);
        }
    }
}

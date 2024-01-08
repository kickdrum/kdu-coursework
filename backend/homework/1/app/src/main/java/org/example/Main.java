package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Initialize modules
        studentRepository repository = new studentRepository();
        LoggerService logger = new LoggerService();

        Scanner scanner = new Scanner(System.in);

        // Main menu
        int choice;
        do {
            System.out.println("\n1. Add a student");
            System.out.println("2. Retrieve a student by ID");
            System.out.println("3. Retrieve a student by ID and Name");
            System.out.println("4. Update student information");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a student
                    addStudent(scanner, repository, logger);
                    break;
                case 2:
                    // Retrieve a student by ID
                    retrieveStudentById(scanner, repository, logger);
                    break;
                case 3:
                    // Retrieve a student by ID and Name
                    retrieveStudentByIdAndName(scanner, repository, logger);
                    break;
                case 4:
                    // Update student information
                    updateStudent(scanner, repository, logger);
                    break;
                case 5:
                    // Exit the application
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        // Close the scanner
        scanner.close();
    }

    private static void addStudent(Scanner scanner, studentRepository repository, LoggerService logger) {
        System.out.print("Enter student details:\nID: ");
        int id = scanner.nextInt();
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Grade: ");
        char grade = scanner.next().charAt(0);

        student newStudent = new student(id, name, age, grade);
        repository.addStudent(newStudent);

        logger.logInfo("Student added: " + newStudent);
    }

    private static void retrieveStudentById(Scanner scanner, studentRepository repository, LoggerService logger) {
        System.out.print("Enter student ID to retrieve: ");
        int retrieveId = scanner.nextInt();
        student retrievedStudent = repository.retrieveStudent(retrieveId);

        if (retrievedStudent != null) {

            System.out.println("ID: " + retrievedStudent.idGetter());
            System.out.println("Name: " + retrievedStudent.nameGetter());
            System.out.println("Age: " + retrievedStudent.ageGetter());
            System.out.println("Grade: " + retrievedStudent.gradeGetter());
            logger.logInfo("Retrieved by ID: " + retrievedStudent);
        }
        else {
            System.out.println("Student not found with ID: " + retrieveId);
            logger.logInfo("Student not found with ID: " + retrieveId);
        }
    }

    private static void retrieveStudentByIdAndName(Scanner scanner, studentRepository repository, LoggerService logger) {
        System.out.print("Enter student ID to retrieve: ");
        int retrieveId = scanner.nextInt();
        System.out.print("Enter student name to retrieve: ");
        String retrieveName = scanner.next();
        student retrievedStudent = repository.retrieveStudent(retrieveId, retrieveName);

        if (retrievedStudent != null) {
            System.out.println("ID: " + retrievedStudent.idGetter());
            System.out.println("Name: " + retrievedStudent.nameGetter());
            System.out.println("Age: " + retrievedStudent.ageGetter());
            System.out.println("Grade: " + retrievedStudent.gradeGetter());
            logger.logInfo("Retrieved by ID and Name: " + retrievedStudent);
        }
        else {
            System.out.println("Student not found with ID: " + retrieveId + " and Name: " + retrieveName);
            logger.logInfo("Student not found with ID: " + retrieveId + " and Name: " + retrieveName);
        }
    }

    private static void updateStudent(Scanner scanner, studentRepository repository, LoggerService logger) {
        System.out.print("Enter student ID to update: ");
        int updateId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter new name: ");
        String updateName = scanner.nextLine();
        System.out.print("Enter new age: ");
        int updateAge = scanner.nextInt();
        System.out.print("Enter new grade: ");
        char updateGrade = scanner.next().charAt(0);
        repository.updateStudent(updateId, updateName, updateAge, updateGrade);

        logger.logInfo("Student with ID " + updateId + " updated. New Name: " + updateName + ", New Age: " + updateAge + ", New Grade: " + updateGrade);
    }
}

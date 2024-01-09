package org.example;

import java.util.*;

/**
 * The main class for the student management application.
 *
 * <p>This class provides a command-line interface for interacting with the StudentRepository.
 * It allows users to add, search, and update student records.
 */
public class Main {
    static final String ENTERSTUDENTIDMESSAGE = "Enter Student Id: ";
    static final String STUDENTWITHIDMESSAGE = "Student with id: ";
    static final String NOTFOUNDMESSAGE = " NOT FOUND.";

    public void printStudent(Student student){
        System.out.printf("Student with Name: %s found.%nId: %d%nAge: %d%nGrade: %c%n",student.getName(),student.getId(),student.getAge(),student.getGrade());
    }

    /**
     * Adds a new student to the repository.
     *
     * @param studentRepositoryObject The repository to add the student to.
     */
    public void addStudent(StudentRepository studentRepositoryObject){
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTERSTUDENTIDMESSAGE);
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Student Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Student Age:");
        int age = scanner.nextInt();
        System.out.println("Enter Student Grade:");
        String buff = scanner.next();
        char grade = buff.charAt(0);
        Student student = new Student(id,name,age,grade);
        studentRepositoryObject.addStudent(student);
    }

    /**
     * Searches for a student by ID and prints their details.
     *
     * @param studentRepositoryObject The repository to search in.
     */
    public void searchStudentByID(StudentRepository studentRepositoryObject){
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTERSTUDENTIDMESSAGE);
        int searchId = scanner.nextInt();
        scanner.nextLine();

        Student searchedStudent = studentRepositoryObject.getStudent(searchId);
        if (searchedStudent != null) {
            this.printStudent(searchedStudent);
        } else {
            System.out.println(STUDENTWITHIDMESSAGE  + searchId + NOTFOUNDMESSAGE);
        }
    }

    /**
     * Searches for a student by name and prints their details.
     *
     * @param studentRepositoryObject The repository to search in.
     */
    public void searchStudentByName(StudentRepository studentRepositoryObject){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Name:");
        String searchName = scanner.nextLine();

        Student searchedStudent = studentRepositoryObject.getStudent(searchName);
        if (searchedStudent != null) {
            this.printStudent(searchedStudent);
        } else {
            System.out.println("Student with Name:"+ searchName + NOTFOUNDMESSAGE);
        }
    }

    /**
     * Updates a student's record.
     *
     * @param studentRepositoryObject The repository containing the student to update.
     */
    public void updateStudentRecord(StudentRepository studentRepositoryObject){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n"+ ENTERSTUDENTIDMESSAGE);
        int id = scanner.nextInt();
        System.out.println("\nChoose an option:\n1. Update Student Name\n2. Update Student Age\n2. Update Student Age\n3. Update Student Grade");
        Student student = studentRepositoryObject.getStudent(id);
        if(student==null) {
            LogBack.filelogger().error("User not found.");
            return;
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice){
            case 1: System.out.println("Enter the updated name:");
                String updatedName = scanner.nextLine();
                studentRepositoryObject.updateStudent(student,updatedName);
                break;

            case 2: System.out.println("Enter the updated Age:");
                int updatedAge = scanner.nextInt();
                scanner.nextLine();
                studentRepositoryObject.updateStudent(student,updatedAge);
                break;

            case 3: System.out.println("Enter the updated Grade:");
                String buff = scanner.nextLine();
                char updatedGrade = buff.charAt(0);
                studentRepositoryObject.updateStudent(student,updatedGrade);
                break;

            default: System.out.println("\nInvalid choice") ;
                break;



        }

    }
    /**
     * The main entry point for the application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Main application = new Main();
        StudentRepository students = new StudentRepository();


        Boolean running = true;
        while (Boolean.TRUE.equals(running)) {

            System.out.println("\nChoose an option:\n1. Add student\n2. Search student by ID\n3. Search student by Name\n4. Update student\n6. Exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:application.addStudent(students);
                    break;
                case 2:
                    application.searchStudentByID(students);
                    break;
                case 3:
                    application.searchStudentByName(students);
                    break;
                case 4:
                    application.updateStudentRecord(students);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    running=false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }


    }
}
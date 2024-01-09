package org.example;

import java.util.*;

public class Main {
    static final  String ENTER_STUDENT_ID_MESSAGE = "Enter Student Id: ";
    static final   String STUDENT_WITH_ID_MESSAGE = "Student with id: ";
    static final  String NOT_FOUND_MESSAGE = " NOT FOUND.";

    public void addStudent(StudentRepository studentRepositoryObject){
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_STUDENT_ID_MESSAGE);
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

    public void searchStudentByID(StudentRepository studentRepositoryObject){
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_STUDENT_ID_MESSAGE);
        int searchId = scanner.nextInt();
        scanner.nextLine();

        Student searchedStudent = studentRepositoryObject.getStudent(searchId);
        if (searchedStudent != null) {
            System.out.println(STUDENT_WITH_ID_MESSAGE + searchId + " found.");
            System.out.println("Name: " + searchedStudent.getName() + "\nAge: " + searchedStudent.getAge()+"\nGrade: " + Character.toString(searchedStudent.getGrade()));
        } else {
            System.out.println(STUDENT_WITH_ID_MESSAGE  + searchId + NOT_FOUND_MESSAGE);
        }
    }

    public void searchStudentByName(StudentRepository studentRepositoryObject){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Name:");
        String searchName = scanner.nextLine();

        Student searchedStudent = studentRepositoryObject.getStudent(searchName);
        if (searchedStudent != null) {
            System.out.println("Student with Name: " + searchName + " found.");
            System.out.println("Id: " + searchedStudent.getId());
            System.out.println("Age: " + searchedStudent.getAge());
            System.out.println("Grade: " + Character.toString(searchedStudent.getGrade()));
        } else {
            System.out.println("Student with Name:"+ searchName + NOT_FOUND_MESSAGE);
        }
    }

    public void updateStudentRecord(StudentRepository studentRepositoryObject){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n"+ENTER_STUDENT_ID_MESSAGE);
        int id = scanner.nextInt();
        System.out.println("\nChoose an option:\n1. Update Student Name\n2. Update Student Age\n2. Update Student Age\n3. Update Student Grade");
        Student student = studentRepositoryObject.getStudent(id);
        if(student==null) {
            System.out.println("User not found.");
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

    public static void main(String[] args) {
        Main application = new Main();
        StudentRepository students = new StudentRepository();
        Boolean running = true;

        while (running) {
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
                    LogBack.filelogger().debug("Exiting the Application");
                    running=false;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }


    }
}
package org.example;

import java.util.*;

public class Main {

    public void addStudent(StudentRepository studentRepositoryObject){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Id:");
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
        System.out.println("Enter Student Id:");
        int searchId = scanner.nextInt();
        scanner.nextLine();

        Student searchedStudent = studentRepositoryObject.getStudent(searchId);
        if (searchedStudent != null) {
            System.out.println("Student with Id: " + searchId + " found.");
            System.out.println("Name: " + searchedStudent.getName());
            System.out.println("Age: " + searchedStudent.getAge());
            System.out.println("Grade: " + Character.toString(searchedStudent.getGrade()));
        } else {
            System.out.println("Student with Id: "  + searchId + " not found!");
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
            System.out.println("Student with Id:"+ searchName +" not found!");
        }
    }

    public void updateStudentRecord(StudentRepository studentRepositoryObject){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the Student Id:");
        int id = scanner.nextInt();
        System.out.println("\nChoose an option:");
        System.out.println("1. Update Student Name");
        System.out.println("2. Update Student Age");
        System.out.println("3. Update Student Grade");
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

        System.out.println("------------------------------------");
        System.out.println("\nStudent Management System");


        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add student");
            System.out.println("2. Search student by ID");
            System.out.println("3. Search student by Name");
            System.out.println("4. Update student");
            System.out.println("6. Exit");
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
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }


    }
}
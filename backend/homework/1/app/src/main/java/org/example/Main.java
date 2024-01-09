package org.example;

import java.util.*;

public class Main {
    static final String ENTERSTUDENTIDMESSAGE = "Enter Student Id: ";
    static final String STUDENTWITHIDMESSAGE = "Student with id: ";
    static final String NOTFOUNDMESSAGE = " NOT FOUND.";


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

    public void searchStudentByID(StudentRepository studentRepositoryObject){
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTERSTUDENTIDMESSAGE);
        int searchId = scanner.nextInt();
        scanner.nextLine();

        Student searchedStudent = studentRepositoryObject.getStudent(searchId);
        if (searchedStudent != null) {
            System.out.printf( "%s  %d found. %n",STUDENTWITHIDMESSAGE,searchId);
            System.out.printf("Name: %s%n", searchedStudent.getName());
            System.out.printf("Age: %d%n",searchedStudent.getAge());
            System.out.printf("Grade: %c%n",searchedStudent.getGrade());
        } else {
            System.out.println(STUDENTWITHIDMESSAGE  + searchId + NOTFOUNDMESSAGE);
        }
    }

    public void searchStudentByName(StudentRepository studentRepositoryObject){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Name:");
        String searchName = scanner.nextLine();

        Student searchedStudent = studentRepositoryObject.getStudent(searchName);
        if (searchedStudent != null) {
            System.out.printf("Student with Name: %s found.",searchName);
            System.out.printf("Id: %d%n", searchedStudent.getId());
            System.out.printf("Age: %d%n",searchedStudent.getAge());
            System.out.printf("Grade: %c%n",searchedStudent.getGrade());
        } else {
            System.out.println("Student with Name:"+ searchName + NOTFOUNDMESSAGE);
        }
    }

    public void updateStudentRecord(StudentRepository studentRepositoryObject){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n"+ ENTERSTUDENTIDMESSAGE);
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
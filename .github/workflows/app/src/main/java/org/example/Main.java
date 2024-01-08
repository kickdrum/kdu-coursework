package org.example;
import java.util.Scanner;

public class Main {
    public  static StudentRepository studentRepository = new StudentRepository();
    public  static loggerclass logger = new loggerclass();

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean flag=true;
        while (flag) {
            System.out.println("Enter 1 to add a student");
            System.out.println("Enter 2 to retrieve a student");
            System.out.println("Enter 3 to Update a student");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                   addstudent();
                    break;
                case 2:
                    retrieveStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                default:
                    flag=false;
                    System.out.println("Invalid option");
            }
        }
    }
    public  static void addstudent(){
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();

        Student newStudent = new Student(id, name, age, grade);
        studentRepository.addStudent(newStudent);
        logger.AddStudent(newStudent);
    }
    public static void retrieveStudent(){
        System.out.println("Enter student ID");
        int id = scanner.nextInt();
        Student student = studentRepository.retrieveStuDetails(id);
        if (student != null) {
            logger.RetrieveStudent(id);
            System.out.println("Here are the student details:" );
            System.out.println("ID:"+student.getID());
            System.out.println("Name:"+student.getName());
            System.out.println("Age:"+student.getAge());
            System.out.println("Grade:"+student.getGrade());
        }
    }
    public static void updateStudent(){
        System.out.println("Enter student ID");
        int id = scanner.nextInt();
        Student student = studentRepository. retrieveStuDetails(id);
        if (student != null) {
            System.out.print("Enter new Age: ");
            int newAge = scanner.nextInt();
            System.out.print("Enter new Grade: ");
            String newGrade = scanner.nextLine();
            student.setAge(newAge);
            student.setGrade(newGrade);
            studentRepository.updateDetails(student);
            logger.UpdateStudent(student);
        }
    }
}
package kdu.backend;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the option ");
            System.out.println("1: Add Student");
            System.out.println("2: Retrieve Details");
            System.out.println("3: Update Name");
            System.out.println("4: Update Age");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter student details:");
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Grade: ");
                    String grade = sc.nextLine();

                    Student newStudent = new Student(id, age, name, grade);
                    repository.add(newStudent);
                    Logging.add(newStudent);
                    break;

                case 2:
                    System.out.print("Enter student ID to retrieve details: ");
                    int retrieveId = sc.nextInt();
                    Student retrievedStudent = repository.retrieve(retrieveId);
                    Logging.retrieve(retrieveId, retrievedStudent);
                    break;

                case 3:
                    System.out.print("Enter student ID to update their Name: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String updatedName = sc.nextLine();
                    Student updatedStudentName = repository.updateStudentName(updateId, updatedName);
                    Logging.updateName(updateId, updatedName, updatedStudentName);
                    break;

                case 4:
                    System.out.print("Enter student ID to update their Age: ");
                    int updateID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new age: ");
                    int updatedAge = sc.nextInt();
                    Student updatedStudentAge = repository.updateStudentAge(updateID, updatedAge);
                    Logging.updateAge(updateID, updatedAge, updatedStudentAge);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}

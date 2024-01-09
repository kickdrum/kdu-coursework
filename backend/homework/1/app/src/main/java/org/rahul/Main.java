package org.rahul;

import java.util.ArrayList;
import java.util.Scanner;

class Helper {
    private final static Scanner scanner = new Scanner(System.in);
    private Helper() {
    }
    public static void printMenu() {
        System.out.println("\n1. Add student \n2. Remove student \n3. Print all students \n4. Print student by ID \n5. Print students by Name \n6. Print students by Grade \n7. Update Student Name \n8. Update Student Grade \n9. Update Student Age \n10. Update complete details of Student \n11. Exit ! \n----------------------------------");
    }

    public static Student enterDetails() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();

        scanner.nextLine();
        System.out.print("Enter student grade: ");
        char grade = scanner.next().charAt(0);

        return new Student(id, name, age, grade);
    }

    public static int enterID() {
        System.out.print("Enter student ID: ");
        return scanner.nextInt();
    }

    public static String enterName() {
        scanner.nextLine();
        System.out.print("Enter student name: ");
        return scanner.nextLine();
    }

    public static char enterGrade() {
        System.out.print("Enter student grade: ");
        return scanner.next().charAt(0);
    }

    public static int enterAge() {
        System.out.print("Enter student age: ");
        return scanner.nextInt();
    }

    public static void printRetrievedStudents(ArrayList<Student> students) {
        for (Student student : students) {
            student.printStudent();
        }
    }

}

public class Main {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            Helper.printMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    Student student = Helper.enterDetails();
                    repository.addStudent(student);
                    Logg.logger.info("Student added successfully");
                    break;
                }
                case 2: {
                    int id = Helper.enterID();
                    repository.removeStudent(id);
                    Logg.logger.info("Student removed successfully");
                    break;
                }
                case 3: {
                    repository.getAllStudents();
                    Logg.logger.info("All students printed successfully");
                    break;
                }
                case 4: {
                    int id = Helper.enterID();
                    ArrayList<Student> students = repository.getStudent(id);
                    if (students.isEmpty()) {
                        System.out.println("No student found with ID: %d", id);
                        Logg.logger.info("No student found with ID: %d", id);
                    } else {
                        Helper.printRetrievedStudents(students);
                        Logg.logger.info("Student printed successfully");
                    }
                    break;
                }
                case 5: {
                    scanner.nextLine();
                    String name = Helper.enterName();
                    ArrayList<Student> students = repository.getStudent(name);
                    if (students.isEmpty()) {
                        System.out.println("No student found with name: %s", name);
                        Logg.logger.info("No student found with name: %s", name);
                    } else {
                        Helper.printRetrievedStudents(students);
                        Logg.logger.info("Student(s) printed successfully");
                    }
                    break;
                }
                case 6: {
                    char grade = Helper.enterGrade();
                    ArrayList<Student> students = repository.getStudent(grade);
                    if (students.isEmpty()) {
                        System.out.println("No student found with grade: %c", grade);
                        Logg.logger.info("No student found with grade: %c", grade);
                    } else {
                        Helper.printRetrievedStudents(students);
                        Logg.logger.info("Student(s) printed successfully");
                    }
                    break;
                }
                case 7: {
                    int id = Helper.enterID();
                    scanner.nextLine();
                    String name = Helper.enterName();
                    repository.updateStudentName(id, name);
                    Logg.logger.info("Student name updated successfully");
                    break;
                }
                case 8: {
                    int id = Helper.enterID();
                    scanner.nextLine();
                    char grade = Helper.enterGrade();
                    repository.updateStudentGrade(id, grade);
                    Logg.logger.info("Student grade updated successfully");
                    break;
                }
                case 9: {
                    int id = Helper.enterID();
//                    scanner.nextLine();
                    int age = Helper.enterAge();
                    repository.updateStudentAge(id, age);
                    Logg.logger.info("Student age updated successfully");
                    break;
                }
                case 10: {
                    Student student = Helper.enterDetails();
                    repository.updateStudent(student);
                    Logg.logger.info("Student updated successfully");
                    break;
                }
                case 11: {
                    exit = true;
                    Logg.logger.info("Exiting...");
                    break;
                }
                default: {
                    System.out.println("Invalid choice!");
                    Logg.logger.info("Invalid choice!");
                }
            }
        }


    }
}
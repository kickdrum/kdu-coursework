package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
    logger loggerMessage=new logger();
    StudentRepository studentManager=new StudentRepository();

    String check="yes";
    String trueValue="yes";
    int numberOfStudents=1;
    Scanner sc=new Scanner(System.in);
    while(check.equals(trueValue)) {
        System.out.println("1:Add a new student \n2:Get student information \n3:update student information");
        System.out.print("Select one of the options : ");
        int currentOption = sc.nextInt();
        if (currentOption == 1) {
            System.out.print("Enter Student Name : ");
            String newName = sc.next();
            System.out.print("Enter Student Age : ");
            int newAge = sc.nextInt();
            System.out.print("Enter Student Grade : ");
            String newGrade = sc.next();

            Student newStudent = new Student();
            newStudent.setStudentId(numberOfStudents);
            numberOfStudents++;
            newStudent.setStudentName(newName);
            newStudent.setStudentGrade(newGrade);
            newStudent.setStudentAge(newAge);
            studentManager.addStudent(newStudent);

        } else if (currentOption == 2) {
            System.out.println("1 : search student information using student ID\n2 : search student information using name");
            System.out.print("Enter choice : ");
            int readChoice = sc.nextInt();
            if (readChoice == 1) {
                System.out.print("Enter Student ID : ");
                int newId = sc.nextInt();
                Student foundStudent = studentManager.retriveStudent(newId);
                if (foundStudent != null) {
                    System.out.println("Student details :- ");
                    System.out.println("Name : " + foundStudent.getStudentName());
                    System.out.println("Age : " + foundStudent.getStudentAge());
                    System.out.println("ID : " + foundStudent.getStudentId());
                    System.out.println("Grade : " + foundStudent.getStudentGrade());
                }
            } else if (readChoice == 2) {
                System.out.print("Enter Student name : ");
                String newName = sc.next();
                Student foundStudent = studentManager.retriveStudent(newName);
                if (foundStudent != null) {
                    System.out.println("Student details :- ");
                    System.out.println("Name : " + foundStudent.getStudentName());
                    System.out.println("Age : " + foundStudent.getStudentAge());
                    System.out.println("ID : " + foundStudent.getStudentId());
                    System.out.println("Grade : " + foundStudent.getStudentGrade());
                }
            } else {
                loggerMessage.CreateLog("Failed : Invalid choice");
            }
        } else if (currentOption == 3) {
            System.out.print("Enter Student ID : ");
            int newId = sc.nextInt();
            System.out.print("Enter student name to be updated : ");
            String newName = sc.next();
            System.out.print("Enter Student Age to be updated : ");
            int newAge = sc.nextInt();
            System.out.print("Enter Student Grade to be updated : ");
            String newGrade = sc.next();

            Student newStudent = new Student();
            newStudent.setStudentId(newId);
            newStudent.setStudentName(newName);
            newStudent.setStudentGrade(newGrade);
            newStudent.setStudentAge(newAge);
            studentManager.updateStudent(newId, newStudent);
        } else {
            loggerMessage.CreateLog("Failed : Invalid choice");
        }
        System.out.print("Do you wish to continue yes or no  :  ");
        check= sc.next();
    }
    sc.close();
    loggerMessage.CreateLog("Program Terminated ");
    }


}

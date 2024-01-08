package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Handled the exception, if some occurs
        try {
            Scanner sc = new Scanner(System.in);
            String res;
            StudentRepository studentRepository1 = new StudentRepository();

            //Created a user driven program for easy function of the application
            do {
                System.out.println("Hello!! Here are some services we provide, choose the appropriate: \n (a) Add a student \n (b) Get Student details using name \n (c) Get Student details using id  \n (d) Update a student details \n (e) Give details of all the Students \n (f) End");
                res = sc.next();
                switch (res) {
                    //Adding a student
                    case "a": {
                        System.out.println("Enter Details");
                        System.out.println("Enter name");
                        sc.nextLine();
                        String name = sc.nextLine().trim();
                        System.out.println("Enter id: ");
                        int id = sc.nextInt();
                        System.out.println("Enter age: ");
                        int age = sc.nextInt();
                        System.out.println("Enter grade: ");
                        String grade = sc.next();
                        studentRepository1.addStudent(id, name, age, grade);
                        break;
                    }
                    case "b": {
                        //retrieving a student using name
                        sc.nextLine();
                        System.out.println("Enter Name: ");
                        String name = sc.nextLine();
                        Student studentRetrieved = studentRepository1.retrieve(name.trim());
//                        System.out.println(studentRetrieved);
                        break;
                    }
                    case "c": {
                        //retrieving a student using id
                        System.out.println("Enter id: ");
                        int id = sc.nextInt();
                        Student studentRetrieved = studentRepository1.retrieve(id);
//                        System.out.println(studentRetrieved);
                        break;
                    }
                    case "d": {
                        //updating a student data
                        System.out.println("Enter Details: ");
                        System.out.println("Enter name: ");
                        sc.nextLine();
                        String name = sc.nextLine().trim();
                        System.out.println("Enter id: ");
                        int id = sc.nextInt();
                        System.out.println("Enter age: ");
                        int age = sc.nextInt();
                        System.out.println("Enter grade: ");
                        String grade = sc.next();
                        studentRepository1.update(id, name, age, grade);
                        break;
                    }
                    case "e": {
                        // Printing all
                        studentRepository1.printAll();
                        break;
                    }
                    case "f": {
                        //Exit
                        System.out.println("Thank You!!");
                        break;
                    }
                    default: {
                        //Handled all other inputs
                        System.out.println("Enter a valid option");
                    }

                }
            } while (!res.equals("f"));
        }catch(Exception E){
            System.out.println("Exception occurred: "+E);
        }



    }
}
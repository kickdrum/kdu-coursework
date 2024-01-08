package org.handson;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    Student getStudentDetail()
    {        System.out.print("\033[H\033[2J");

        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Student ID: ");

        int id = sc.nextInt();
        student.setID(id);
sc.nextLine();
        System.out.println("\nEnter Student Name: ");
        String name = sc.nextLine();
        student.setName(name);

        System.out.println("\nEnter Student Age: ");
        int age = sc.nextInt();
        student.setAge(age);

        System.out.println("\nEnter Student Grade: ");
        String grade = sc.next();
        char letter = grade.charAt(0);
        student.setGrade(letter);
        return student;

    }

    void Update(StudentRepo studentRepoobj)
    {
    System.out.print("\033[H\033[2J");
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the ID of the student to be updated:");
        int ID = sc.nextInt();
        System.out.println("\nChoose one of the following:\n1: Update the age\n2:Update the grade");
        Student student = studentRepoobj.getStudent(ID);
        if(student==null) {System.out.println("User not found");return;}
        int option = sc.nextInt();
        switch(option)
        {
            case 1: System.out.println("\nEnter the new value of age: ");
                    int newage =  sc.nextInt();
                    studentRepoobj.updateStudentAge(newage,student); break;
            case 2: System.out.println("\nEnter the new value of the grade");
                String newgrade =  sc.next();
                char letter  = newgrade.charAt(0);
                studentRepoobj.updateStudentAge(letter,student); break;
            default: System.out.println("\nInvalid option, Try Again") ;break;
        }
    }

    void Retrieve(StudentRepo studentRepoObj)
    {
        System.out.println("\nRetrieve by one of the following:\n1: ID\n2:Name");
        Scanner sc = new Scanner(System.in);

        int option = sc.nextInt();
        switch(option)
        {
            case 1:
                System.out.println("\nEnter the ID of the student :");
                int ID = sc.nextInt();
                Student st1 = studentRepoObj.getStudent(ID);
                if(st1!=null)
                    System.out.println("\nID: "+st1.getID()+" Name: "+st1.getName()+" Grade:"+st1.getGrade()+" Age:"+st1.getAge()+" ");

                else
                    System.out.println("Unable to find user");

                break;
            case 2:      sc.nextLine();
                System.out.println("\nEnter the name of the student:");
                String name = sc.nextLine();
               Student st = studentRepoObj.getStudent(name);
               if(st!=null)
                System.out.println("\nID: "+st.getID()+" Name: "+st.getName()+" Grade:"+st.getGrade()+" Age:"+st.getAge()+" ");
               else
                   System.out.println("Unable to find user");
                break;
            default: System.out.println("\nInvalid option, Try Again") ;break;

        }

    }
    public static void main(String[] args) {
        char contin = 'n';

        Main driver = new Main();

        System.out.println("Hi there! Welcome to the Kickdrum Student Portal");
        do {   System.out.println("\nChoose one of the following to get what you want done!\n1:Add student\n2:Update Student Info\n3:Retrieve Student\n4.Exit");
try {
    StudentRepo studentRepoobj = new StudentRepo();
    Scanner sc = new Scanner(System.in);
    int option = sc.nextInt();

    switch (option) {
        case 1:
            Student student = driver.getStudentDetail();
            studentRepoobj.addStudent(student);
            break;
        case 2:
            driver.Update(studentRepoobj);
            break;
        case 3:
            driver.Retrieve(studentRepoobj);
            break;
        case 4:
            exit(0);
        default:
            System.out.println("\nInvalid option, Exiting..");

    }
    System.out.println("Continue?");
    String str = sc.next();
    contin = str.charAt(0);
}catch(Exception e)
{System.out.println("Some error occured, press yes to continue, n to exit\n");}
        }while(contin != 'n');
        
    }
}
package org.example;
import org.example.Student;
import org.example.StudentRepository;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        StudentRepository r=new StudentRepository();

        Student []s=new Student[10];

        int i=0;
        //System.out.print("Enter the number of students : ")
        while(true) {
            System.out.print("\n1. Add\n2. Update\n3. Retrieve\n4. Exit\nEnter your choice : ");
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    if(i<10) {
                        s[i] = r.addStudent(s[i]);
                        //r.display(s[i]);
                        i++;
                        Logback.getMsg().debug("Added Successfully");
                    }
                    else{
                        System.out.println("\nArray size occupied");
                    }
                    break;

                case 2:
                    System.out.print("\n1.Update age\n2.Update grade\nEnter your choice : ");
                    int ch = sc.nextInt();

                    System.out.print("\nEnter the id : ");
                    int id = sc.nextInt();

                    if (ch == 1) {
                        System.out.print("\nEnter the age : ");
                        int age = sc.nextInt();
                        r.update(s, id, age);
                        Logback.getMsg().debug("Updated Successfully");
                    } else if (ch == 2) {
                        System.out.print("\nEnter the grade : ");
                        char grade = sc.next().charAt(0);
                        r.update(s, id, grade);
                        Logback.getMsg().debug("Updated Successfully");
                    }
                    break;

                case 3:
                    System.out.print("\nEnter the id : ");
                    int id1 = sc.nextInt();
                    Student ret = r.retrieve(s, id1);
                    if(ret!=null)
                    {
                        r.display(ret);
                        Logback.getMsg().debug("Retrieved Successfully");

                    }
                    else;
                    break;

                case 4:
                {
                    Logback.getMsg().debug("Terminating program");
                    return;
                }
            }
        }
    }
}
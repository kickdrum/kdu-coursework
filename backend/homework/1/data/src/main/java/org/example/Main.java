package org.example;

import java.util.*;
import org.example.Student;
class StudentRepository {
    private Student[] student;
    public Student addStudent(Student s){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter the id,name,age and grade");
        int id=sc.nextInt();
        sc.skip("\n");
        String name=sc.nextLine();
        int age=sc.nextInt();
        char grade=sc.next().charAt(0);

        s=new Student(id,name,age,grade);
        return s;
    }

    public Student retrieve(Student []s,int id){
        try {
            for (int i = 0; i < s.length; i++) {
                if (s[i].getId() == id) {
                    return s[i];
                }
            }
            return null;
        }
        catch(Exception e){
            Logback.getMsg().debug("Terminating program");
            System.out.println("Id not found");
        }
        return null;
    }

    public Student retrieve(Student []s,String name){
        try {
            for (int i = 0; i < s.length; i++) {
                if (s[i].getName().equals(name)) {
                    return s[i];
                }
            }
        }
        catch(Exception e){
            Logback.getMsg().error("Terminating program");
            System.out.println("Name not found");
        }

        return null;
    }

    public void update(Student []s,int id, int newAge){
        for(int i=0;i<s.length;i++){
            if(s[i].getId()==id){
                s[i].setAge(newAge);
                return;
            }
        }
        System.out.println("Id not found");
    }

    public void update(Student []s,int id, char newGrade){
        for(int i=0;i<s.length;i++){
            if(s[i].getId()==id){
                s[i].setGrade(newGrade);
                return;
            }
        }
        System.out.println("Id not found");
    }

    public void display(Student s){
        System.out.print("\nID    : "+s.getId());
        System.out.print("\nName  : "+s.getName());
        System.out.print("\nAge   : "+s.getAge());
        System.out.println("\nGrade : "+s.getGrade());
    }

}

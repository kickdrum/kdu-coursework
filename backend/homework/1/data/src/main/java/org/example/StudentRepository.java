package org.example;

import java.util.ArrayList;

public class StudentRepository {
    ArrayList<Student> array = new ArrayList<Student>();
//    Student st=new Student(1,"Arunain",21,"A");
    public void addStudent(Student st){
        array.add(st);
    }

    public Student retrieveStudent(int id){
        for(Student v:array){
            int currentid=v.getId();
            if(currentid==id) return v;
        }
        System.out.println("Please enter valid id");
        return null;
    }

    public Student retrieveStudent(int id, String name){
        for(Student v:array){
            int currentid=v.getId();
            String currentname=v.getName();
            if(currentid==id && currentname.equals(name)) return v;
        }
        System.out.println("Please enter valid id");
        return null;
    }

    public void updateStudent(Student updatedStudent) {
        for(Student v:array){
            if (v.getId() == updatedStudent.getId()) {
                v= updatedStudent;
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found. Cannot update.");
    }

}

package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
public class StudentRepository{
    public static ArrayList<Student> students=new ArrayList<>();
    private static final Logger slf4jLogger = LoggerFactory.getLogger(LogBack.class);

    public void addStudent(Student x){
        students.add(x);
        slf4jLogger.info("Your Student is Added");
    }

    public Student getStudent(String id){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId().equals(id)){
                slf4jLogger.info("Student is Retrieved");
                return students.get(i);
            }
        }
        slf4jLogger.info("Student is NOT Retrieved for this ID");
        return null;
    }

    public ArrayList<Student> updateStudentName(String newName,String id){
        for(int i=0;i< students.size();i++){
            if(students.get(i).getId().equals(id)){
                students.get(i).setName(newName);
                slf4jLogger.info("Student name is Updated");
                return students;
            }
        }
        slf4jLogger.info("Student name is NOT Updated for this ID");
        return students;
    }

    public ArrayList<Student> updateStudentAge(int newAge, String id){
        for(int i=0;i< students.size();i++){
            if(students.get(i).getId().equals(id)){
                students.get(i).setAge(newAge);
                slf4jLogger.info("Student Age is Updated");
                return students;
            }
        }
        slf4jLogger.info("Student Age cannot be Updated for tis ID");
        return students;
    }

    public ArrayList<Student> updateStudentGrade(char newGrade, String id){
        for(int i=0;i< students.size();i++){
            if(students.get(i).getId().equals(id)){
                students.get(i).setGrade(newGrade);
                slf4jLogger.info("Student Grade is Updated");
                return students;
            }
        }
        slf4jLogger.info("Student Grade cannot be Updated for tis ID");
        return students;
    }
}

package org.example;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentRepository {

    ArrayList<Student> Stuarray;
    StudentRepository(){             //constructor
        Stuarray=new ArrayList<Student>();
    }
    void addStudent(Student newstudent){    // to add values in arraylist
        Stuarray.add(newstudent);
        System.out.println("Student added");
    }
    Student retrieveStuDetails(int id){   //to retrieve a student's details based on his id
        for(Student itr:Stuarray){
            if(itr.getID()==id) {
                System.out.println("student retrieved by id:");
                return itr;
            }
        }

//        logger.warn("Student Id not found:{}",id);
        return null;
    }
    Student retrieveStuDetails(int id,String name){
        for(Student itr:Stuarray){
            if(itr.getID()==id && itr.getName().equals(name)) {
                System.out.println("student retrieved by id,name");
                return itr;
            }
        }
            System.out.println("Student id,Name not found:{},{}");
        return null;
    }
    void updateDetails(Student student){
        for(Student itr:Stuarray){
            if(itr.getID()==student.getID()){
                itr.setName(student.getName());
                itr.setAge(student.getAge());
                itr.setGrade(student.getGrade());
            }
        }
        System.out.println("Student Id not found");
    }

}

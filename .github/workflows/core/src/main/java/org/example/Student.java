package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Student{
    private static final Logger logger = LoggerFactory.getLogger(Student.class);
    int id;
    String name;
    int age;
    String grade;
    Student(int id,String name,int age,String grade){
        this.id=id;
        this.name=name;
        this.age=age;
       this.grade=grade;
       logger.info("new student added:{}",this);
    }
    public void setID(){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setGrade(String grade){
        this.grade=grade;
    }
    public int getID(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getGrade(){
        return this.grade;
    }

}
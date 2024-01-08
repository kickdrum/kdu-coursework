package org.example;

import java.util.*;

class Student
{
    private  int id;
    private  String name;
    private  int age;
    private  char grade;
    public Student(int id,String name,int age, char grade)
    {
        this.id=id;
        this.name=name;
        this.age=age;
        this.grade=grade;
    }

    public  int getId(){
        return id;
    }
    public  String getName(){
        return name;
    }
    public  int getAge(){ return age;    }
    public  char getGrade(){
        return grade;
    }

    public void setId(int newId){
        id=newId;
    }
    public void setName(String newName){
        name=newName;
    }
    public void setAge(int newAge){
        this.age=newAge;
    }
    public void setGrade(char newGrade){
        this.grade=newGrade;
    }

}
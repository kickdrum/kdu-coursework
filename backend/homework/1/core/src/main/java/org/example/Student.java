package org.example;

public class Student{
    int id;
    String name;
    int age;
    String grade;
    Student(int id,String name,int age,String grade){
        this.id=id;
        this.name=name;
        this.age=age;
        this.grade=grade;
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
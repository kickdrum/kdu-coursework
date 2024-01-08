package org.example;

public class Student {
    int id;
    String name;
    int age;
    String grade;

    Student(int id, String name, int age, String grade){
        this.id=id;
        this.name=name;
        this.age=age;
        this.grade=grade;
    }
    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id=id;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age =age;
    }

    public String getName(){
        return this.name;
    }


    public void setName(String name){
        this.name= name;
    }

    public String getGrade(){
        return this.grade;
    }

    public void setGrade(String grade){
        this.grade=grade;
    }


}

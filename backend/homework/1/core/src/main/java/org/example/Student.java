package org.example;

public class Student {
    private final int id;
    private String name;
    private int age;
    private char grade;

    //Constructor
    public Student(int id,String name,int age,char grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    //getters
    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public int getGrade(){
        return this.grade;
    }

    //setters
    public void setName(String updatedName){
        this.name = updatedName;
    }
    public void setAge(int updatedAge){
        this.age = updatedAge;
    }

    public void setGrade(char updatedGrade){
        this.grade = updatedGrade;
    }






}

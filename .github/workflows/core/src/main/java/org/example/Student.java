package org.example;

public class Student{
    private int ID;
    private String name;
    private int age;
    private String grade;

    public Student(int ID, String name, int age, String grade){
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    void set_ID(int id){
        this.ID = id;
    }

    void set_name(String name){
        this.name = name;
    }

    void set_age(int age){
        this.age = age;
    }

    void set_grade(String grade){
        this.grade = grade;
    }
    int get_ID(){
        return ID;
    }

    String get_name(){
        return name;
    }
    int get_age(){
        return age;
    }
    String get_grade(){
        return grade;
    }

}

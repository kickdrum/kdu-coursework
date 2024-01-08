package org.student;

public class Student {
    private int id;
    private String name;
    private int age;
    private float grade;

    public Student(int id,String name,int age,float grade){
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int newId){
        this.id = newId;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int newAge){
        this.age = newAge;
    }

    public float getGrade(){
        return this.grade;
    }

    public void setGrade(float newGrade){
        this.grade = newGrade;
    }
}


package org.example;

public class Student {
    private String id;
    private String name;
    private int age;
    private  char grade;
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }

    public char getGrade(){
        return grade;
    }
    public void setGrade(char grade){
        this.grade=grade;
    }
}

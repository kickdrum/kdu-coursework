package org.example;

public class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    public Student(){}
    public Student(int i, String n, int a, String g){
        id = i;
        name = n;
        age = a;
        grade = g;
    }

    public int getId(){
        return id;
    }

    public void setId(int i){
        id = i;
    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        name = n;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int a){
        age = a;
    }

    public String getGrade(){
        return grade;
    }

    public void setGrade(String g){
        grade = g;
    }

    public String toString() {
        return "{id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                '}';
    }
}

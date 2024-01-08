package org.example;

public class Student {

    private int id;
    private String Name;
    private int age;
    private String grade;

    Student(int id,String Name,int age,String grade){
        this.id=id;
        this.Name=Name;
        this.age=age;
        this.grade=grade;
    }

//    Student(int id){
//        this.id=id;
//    }
//    Student (String Name){
//        this.Name=Name;
//    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: "+this.Name+" Id: "+this.id+" age: "+this.age+" grade: "+this.grade+" ";
    }
}

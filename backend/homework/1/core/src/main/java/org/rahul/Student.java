package org.rahul;

public class Student {
    private String name;
    private int age;
    private int id;
    private char grade;

    public Student(int id, String name, int age, char grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public char getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Age cannot be negative");
        } else {
            this.age = age;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public void printStudent() {
        System.out.println("ID: " + this.id + "      Name: " + this.name + "       Age: " + this.age + "       Grade: " + this.grade);
    }
}

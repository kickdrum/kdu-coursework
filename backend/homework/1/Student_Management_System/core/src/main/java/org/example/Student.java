package org.example;

public class Student {
    private int studentId,studentAge;
    private String studentName;
    private char studentGrade;

    public  Student(int id,String name,int age,char grade) {
        studentId=id;
        studentName=name;
        studentAge=age;
        studentGrade=grade;
    }
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String name) {
        studentName=name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int id) {
        studentId=id;
    }

    public int getStudentAge() {
        return studentAge;
    }
    public void setStudentAge(int age) {
        studentAge=age;
    }

    public char getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(char grade) {
        this.studentGrade = grade;
    }
}

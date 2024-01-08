package org.example;

public class Student {
    private int studentId;
    private String studentName;
    private int studentAge;
    private String studentGrade;

    public void setStudentId(int studentIdValue) {
        this.studentId = studentIdValue;
    }
    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentName(String studentNameValue) {
        this.studentName = studentNameValue;
    }
    public String getStudentName() {
        return this.studentName;
    }
    public void setStudentAge(int studentAgeValue) {
        this.studentAge= studentAgeValue;
    }
    public int getStudentAge() {
        return this.studentAge;
    }
    public void setStudentGrade(String studentGradeValue) {
        this.studentGrade = studentGradeValue;
    }
    public String getStudentGrade() {
        return this.studentGrade;
    }
}

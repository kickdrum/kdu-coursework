package org.example.ques1and2.hospitalMangementSystem;

public class Staff extends User {
    private long staffID;
    private int yearsOfExperience;
    private String description;
    private double salary;
    private int age;
    private boolean smoker;

    public long getStaffID() {
        return staffID;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getDescription() {
        return description;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }

    public void setStaffID(long staffID) {
        this.staffID = staffID;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

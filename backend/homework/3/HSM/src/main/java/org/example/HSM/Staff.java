package org.example.HSM;

public class Staff extends User{
    private long staffId;
    private int yearsOfExperience;
    private String description;
    private double salary;
    public Staff() {

    }

    public long getStaffId(){
        return staffId;
    }
    public void setStaffId(long staffId){
        this.staffId=staffId;
    }

    public int getYearsOfExperience(){
        return yearsOfExperience;
    }
    public void setYearsOfExperience(int yearsOfExperience){
        this.yearsOfExperience=yearsOfExperience;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
}



package org.example;


public class user {

    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private boolean insured;
    private healthInsurancePlan insurancePlan = null;
    private int age;
    private boolean smoking;
    public user(){}
    public user(long id, String firstName, String lastName, String gender, String email, boolean insured, healthInsurancePlan insurancePlan, int age, boolean smoking) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.insured = insured;
        this.insurancePlan = insurancePlan;
        this.age = age;
        this.smoking = smoking;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean getInsured() {
        return insured;
    }
    public void setInsured(boolean insured) {
        this.insured = insured;
    }
    public healthInsurancePlan getInsurancePlan(){
        return insurancePlan;
    }
    public void setInsurancePlan(healthInsurancePlan insurancePlan){
        this.insurancePlan = insurancePlan;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean getSmoking() {
        return smoking;
    }
    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

}
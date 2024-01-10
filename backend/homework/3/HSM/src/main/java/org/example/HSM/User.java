package org.example.HSM;

import org.example.BillingComponent.HealthInsurancePlan;

public abstract class User {
    private int id;
    private String firstName;
    private String LastName;
    private String gender;
    private String email;
    private int age;
    private boolean smoking;
    private boolean insured;
    private HealthInsurancePlan insurancePlan;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getLastNAme(){
        return LastName;
    }
    public void setLAstName(String lAstName){
        this.LastName=LastName;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getEmail(){
        return email;
    }
    public void setId(String email){
        this.email=email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public HealthInsurancePlan getInsurancePlan() {
        return insurancePlan;
    }

    public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
        this.insurancePlan = insurancePlan;
    }
}

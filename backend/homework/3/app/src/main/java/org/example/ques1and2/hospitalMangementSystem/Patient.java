package org.example.ques1and2.hospitalMangementSystem;


import org.example.ques1and2.billingComponent.HealthInsurancePlan;

public class Patient extends User {
    private long patientID;

    public long getPatientID() {
        return patientID;
    }
    private boolean insured;
    private HealthInsurancePlan insurancePlan = null;

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

    public void setPatientID(long patientID) {
        this.patientID = patientID;
    }



}

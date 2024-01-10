package org.example;

import billing.HealthInsurancePlan;

public class Patient extends User{

    private long patientId;
    private boolean insurance;

    private HealthInsurancePlan insurancePlan;
    public long getPatientId() {
        return patientId;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public HealthInsurancePlan getInsurancePlan() {
        return insurancePlan;
    }

    public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
        this.insurancePlan = insurancePlan;
    }

}

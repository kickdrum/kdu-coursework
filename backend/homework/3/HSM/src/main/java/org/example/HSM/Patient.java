package org.example.hsm;
import org.example.billingcomponent.HealthInsurancePlan;
public class Patient extends User{
    private long patientId;
    private boolean insured;
    private HealthInsurancePlan insurancePlan;


    public long getPatientId(){
        return patientId;
    }
    public void setPatientId(long patientId){
        this.patientId=patientId;
    }
    public boolean getInsured(){
        return insured;
    }
    @Override
    public void setInsured(boolean insured){
        this.insured=insured;
    }
    @Override

    public HealthInsurancePlan getInsurancePlan() {
        return insurancePlan;
    }
@Override
    public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
        this.insurancePlan = insurancePlan;
    }
}


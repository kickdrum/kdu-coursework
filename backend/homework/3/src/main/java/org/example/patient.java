package org.example;

public class patient extends user {
    private long patientId;

    public patient(){

    }
    public patient(long id, String firstName, String lastName, String gender, String email, long patientId, boolean insured, healthInsurancePlan insurancePlan,int age, boolean smoking) {
        super(id, firstName, lastName, gender, email, insured, insurancePlan, age, smoking);
        this.patientId = patientId;
    }

    public long getPatientId() {
        return patientId;
    }
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }
}

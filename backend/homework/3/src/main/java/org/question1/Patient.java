package org.question1;

public class Patient extends User{
    private long patientId;
    private Boolean insured;

    //setter and getter
    public long getPatientId() {
        return patientId;
    }
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }
    public Boolean getInsured() {
        return insured;
    }
    public void setInsured(Boolean insured) {
        this.insured = insured;
    }
}

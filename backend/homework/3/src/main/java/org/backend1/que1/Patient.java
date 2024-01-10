package org.backend1.que1;

/**
 * Class referenced form first question
 */
public class Patient extends User{
    private long patientId;
    private boolean insured;

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }
}

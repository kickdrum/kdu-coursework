package org.handson.question3;

/**
 *
 */
public class Patient extends User {

    private long patientId;
    /**
     * Retrieves the patient ID.
     *
     * @return  the patient ID
     */
    public long getPatientId() {
        return patientId;
    }

    /**
     * @param patientId
     */
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }


}

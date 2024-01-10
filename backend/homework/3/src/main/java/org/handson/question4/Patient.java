package org.handson.question4;

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
     * @param patientId - patient ID of the patient
     */
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }


}

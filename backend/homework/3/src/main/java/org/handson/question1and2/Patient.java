package org.handson.question1and2;

/**
 *
 */
public class Patient extends User {

    private long patientId;
    private boolean insured;

    private HealthInsurancePlan healthInsurancePlan;


    public long getPatientId() {
        return patientId;
    }

    /**
     * @param patientId
     */
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }
    /**
     * Returns whether the object is insured or not.
     *
     * @return  true if the object is insured, false otherwise
     */
    public boolean isInsured() {
        return insured;
    }
    /**
     * Sets the value of the "insured" property.
     *
     * @param  insured  the new value for the "insured" property
     */
    public void setInsured(boolean insured) {
        this.insured = insured;
    }
    /**
     * Returns the health insurance plan associated with this object.
     *
     * @return the health insurance plan
     */
    public HealthInsurancePlan getInsurancePlan() {
        return healthInsurancePlan;
    }
    /**
     * Sets the health insurance plan for the person.
     *
     * @param  healthInsurancePlan  the health insurance plan to be set
     */
    public void setInsurancePlan(HealthInsurancePlan healthInsurancePlan) {
        this.healthInsurancePlan = healthInsurancePlan;
    }
}

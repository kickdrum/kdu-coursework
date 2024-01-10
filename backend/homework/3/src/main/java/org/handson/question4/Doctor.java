package org.handson.question4;

public class Doctor extends Staff {
    private long doctorId;
    private String specialization;

    /**
     * Retrieves the specialization of the object.
     *
     * @return         	the specialization of the object
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Sets the specialization of the object.
     *
     * @param  specialization  the specialization to be set
     *
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Retrieves the doctor ID.
     *
     * @return the doctor ID
     */
    public long getDoctorId() {
        return doctorId;
    }

    /**
     * Sets the doctor ID.
     *
     * @param  doctorId  the ID of the doctor
     */
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }
}

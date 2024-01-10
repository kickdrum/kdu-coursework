package org.handson.question3;

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
     * This function returns the doctor ID.
     *
     * @return  the doctor ID
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    /**
     * Retrieves the ID of the doctor.
     *
     * @return  the ID of the doctor
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

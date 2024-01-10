package org.question1;

public class Doctor extends Staff{
    private long doctorId;
    private String  specialization;

    //setter and getter
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }
    public long getDoctorId() {
        return doctorId;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}

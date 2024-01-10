package org.example.ques1and2.hospitalMangementSystem;

public class Doctor extends Staff {
    private long doctorID;
    private String specialization;

    public long getDoctorID() {
        return doctorID;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setDoctorID(long doctorID) {
        this.doctorID = doctorID;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}

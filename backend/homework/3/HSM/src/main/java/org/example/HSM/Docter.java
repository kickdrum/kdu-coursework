package org.example.hsm;

public class Docter extends Staff {
    private long doctorId;
    private String specialization;

    public long getDoctorId(){
        return doctorId;
    }
    public void setDoctorId(long doctorId){
        this.doctorId=doctorId;
    }

    public String getSpecialization(){
        return specialization;
    }
    public void setSpecialization(String specialization){
        this.specialization=specialization;
    }
}

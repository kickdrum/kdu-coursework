package org.example;

public class doctor extends staff {
    private long doctorId;
    private String specialization;

    public doctor(long id, String firstName, String lastName, String gender, String email, long staffId, int yearsOfExperience, String description, double salary,long doctorId, String specialization, boolean insured, healthInsurancePlan insurancePlan, int age, boolean smoking){
        super(id, firstName, lastName, gender, email, staffId, yearsOfExperience, description, salary, insured, insurancePlan, age, smoking);
        this.doctorId = doctorId;
        this.specialization = specialization;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}


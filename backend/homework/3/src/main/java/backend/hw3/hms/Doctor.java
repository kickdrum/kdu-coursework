package backend.hw3.hms;

public class Doctor extends Staff {
    private long doctorId;
    private String specialization;

    public long getDoctorId() {
        return doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}

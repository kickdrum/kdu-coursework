package question2;

public class Patient extends User{
    private long patientId;
    private Boolean insured;

    private HealthInsurancePlan insurancePlan;

    //setter and getter
    public long getPatientId() {
        return patientId;
    }
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }
    public Boolean getInsured() {
        return insured;
    }
    public void setInsured(Boolean insured) {
        this.insured = insured;
    }

    public HealthInsurancePlan getInsurancePlan() {
        return insurancePlan;
    }

    public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
        this.insurancePlan = insurancePlan;
    }
//    HealthInsurancePlan insurancePlan=
}

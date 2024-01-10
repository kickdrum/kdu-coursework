package shrishti.example.BillingComponent;


public class Patient extends User {
    private long patientId;
    private boolean insured;

    public long getPatientId(){
        return patientId;
    }
    public void setPatientId(long patientId){
        this.patientId=patientId;
    }

    public boolean getInsured(){
        return insured;
    }
    public void setInsured(boolean insured){
        this.insured=insured;
    }

}
package question3;

import billing.HealthInsurancePlan;

public class Patient extends User{

    private long patentId;
    public long getPatentId() {
        return patentId;
    }

    public void setPatentId(long patentId) {
        this.patentId = patentId;
    }

}

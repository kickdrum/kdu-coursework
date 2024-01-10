package question3;

import question4.InsuranceBrand;

public abstract class HealthInsurancePlan {


    private InsuranceBrand offeredBy;
    private double coverage;

    public InsuranceBrand getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(InsuranceBrand offeredBy) {
        this.offeredBy = offeredBy;
    }

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }
    public abstract double computeMonthlyPremium(double salary);
    public abstract double computeMonthlyPremium(double salary,int age ,boolean smoking);
}

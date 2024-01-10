package org.backend1.que4;


// HealthInsurancePlan class with coverage field
abstract public class HealthInsurancePlan {
    private double coverage;

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    private InsuranceBrand offeredBy;

    public InsuranceBrand getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(InsuranceBrand offeredBy) {
        this.offeredBy = offeredBy;
    }

    public double computeMonthlyPremium(double salary, int age,
                                        boolean smoking) {
        return 0.08 * salary +
                getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }



}


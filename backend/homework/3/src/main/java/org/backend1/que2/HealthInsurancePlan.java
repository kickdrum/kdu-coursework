package org.backend1.que2;

/**
 * Class referenced from second question
 */
// HealthInsurancePlan class with coverage field
public class HealthInsurancePlan {
    private double coverage;

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    // Don't worry about the below code and also the InsuranceBrand class
    private InsuranceBrand offeredBy;

    public InsuranceBrand getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(InsuranceBrand offeredBy) {
        this.offeredBy = offeredBy;
    }
}


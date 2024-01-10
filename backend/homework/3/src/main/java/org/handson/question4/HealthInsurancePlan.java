package org.handson.question4;

abstract class HealthInsurancePlan {
    private double coverage;
private double premium;
    private InsuranceBrand offeredBy;

    public  HealthInsurancePlan(double coverage,double premium)
    {
        this.coverage = coverage;this.premium=premium;
    }

    /**
     * Retrieves the insurance brand that offers this policy.
     *
     * @return  the insurance brand that offers this policy
     */
    public InsuranceBrand getOfferedBy() {
        return offeredBy;
    }
    abstract double computeMonthlyPremium(double salary,int age,boolean smoking);
    /**
     * Sets the insurance brand that offers this insurance.
     *
     * @param  offeredBy  the insurance brand to set
     */
    public void setOfferedBy(InsuranceBrand offeredBy) {
        this.offeredBy = offeredBy;
    }

    /**
     * Gets the coverage of the function.
     *
     * @return the coverage value
     */
    public double getCoverage() {
        return coverage;
    }

    /**
     * Sets the coverage value for the object.
     *
     * @param  coverage   the coverage value to be set
     */
    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }
}

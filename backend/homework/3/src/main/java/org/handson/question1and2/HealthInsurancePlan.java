package org.handson.question1and2;

public class HealthInsurancePlan {
    private double coverage;

    private InsuranceBrand offeredBy;

    public  HealthInsurancePlan(double coverage)
    {
        this.coverage = coverage;
    }
    /**
     * Returns the InsuranceBrand that offers this particular insurance.
     *
     * @return the InsuranceBrand that offers this particular insurance.
     */
    public InsuranceBrand getOfferedBy() {
        return offeredBy;
    }
    /**
     * Sets the insurance brand that offers this insurance.
     *
     * @param  offeredBy  the insurance brand offering this insurance
     */
    public void setOfferedBy(InsuranceBrand offeredBy) {
        this.offeredBy = offeredBy;
    }
    /**
     * Returns the coverage of the function.
     *
     * @return the coverage of the function
     */
    public double getCoverage() {
        return coverage;
    }
    /**
     * Sets the coverage value for the object.
     *
     * @param  coverage  the new coverage value to be set
     */
    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }
}

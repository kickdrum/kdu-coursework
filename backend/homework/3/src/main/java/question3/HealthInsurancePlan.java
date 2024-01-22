package question3;

public abstract class HealthInsurancePlan {
    // Code for 'coverage' field goes here
    // Don't worry about the below code and also the InsuranceBrand class
    private double coverage;
    private double discount;
    private InsuranceBrand offeredBy;

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

    public double getDiscount() {
        return discount;
    }

    public abstract double computeMonthlyPremium(double salary);

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
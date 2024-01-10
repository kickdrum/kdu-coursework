package question2;

//Platinum plan has the highest coverage of 0.9, i.e., it covers 90% of the total
// medical expenses and the patient would pay the remaining 10%. So, if the total
// medical expense was $1000, then the insurance company would pay $900 ($1000 * 0.9) while
// the patient would pay the remaining $100.

//The coverage offered by GoldPlan, SilverPlan, and BronzePlan are 0.8, 0.7, and 0.6 respectively.
public class HealthInsurancePlan{
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

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}

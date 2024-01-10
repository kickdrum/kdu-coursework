package shrishti.example.BillingComponent;
public class PlatinumPlan extends HealthInsurancePlan{
    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.08 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
    PlatinumPlan() {
        this.setCoverage(0.9);
        this.setDiscount(50);

    }

}

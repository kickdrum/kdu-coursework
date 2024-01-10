package shrishti.example.BillingComponent;

public class GoldPlan extends HealthInsurancePlan {
    @Override
    public double computeMonthlyPremium(double salary,int age, boolean smoking) {
        return 0.07 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }

    GoldPlan(){
        this.setCoverage(0.7);
        this.setDiscount(40);
    }
}

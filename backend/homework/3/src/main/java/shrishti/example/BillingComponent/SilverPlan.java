package shrishti.example.BillingComponent;

public class SilverPlan extends HealthInsurancePlan {
    @Override
    public double computeMonthlyPremium(double salary,int age, boolean smoking) {
        return 0.06 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }

    SilverPlan(){
        this.setCoverage(0.7);
        this.setDiscount(30);

    }
}

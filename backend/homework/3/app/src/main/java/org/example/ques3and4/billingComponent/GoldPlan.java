package org.example.ques3and4.billingComponent;

public class GoldPlan extends HealthInsurancePlan {
    public GoldPlan() {
        setCoverage(0.8);
    }
    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.07 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
}

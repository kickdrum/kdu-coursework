package org.example.ques3and4.billingComponent;

public class SilverPlan extends HealthInsurancePlan {
    public SilverPlan() {
        setCoverage(0.7);
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.06 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
}

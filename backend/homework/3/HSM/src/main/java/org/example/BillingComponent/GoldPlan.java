package org.example.billingcomponent;

public class GoldPlan extends HealthInsurancePlan {
    public GoldPlan() {
        setCoverage(0.8);
    }
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.07 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
}
package org.example.HMS;

public class GoldPlan extends HealthInsurancePlan{
    public GoldPlan() {
        setCoverage(0.8);
    }
    public double computeMonthlyPremium(double salary, int age, boolean userSmokes) {
        return 0.07 * salary + getOfferedBy().computeMonthlyPremium(this, age, userSmokes);
    }
}
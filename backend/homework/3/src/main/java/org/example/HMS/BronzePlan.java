package org.example.HMS;

public class BronzePlan extends HealthInsurancePlan{
    public BronzePlan() {
        setCoverage(0.6);
    }
    public double computeMonthlyPremium(double salary, int age, boolean userSmokes) {
        return 0.05 * salary + getOfferedBy().computeMonthlyPremium(this, age, userSmokes);
    }
}
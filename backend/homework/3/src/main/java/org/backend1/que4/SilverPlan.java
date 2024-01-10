package org.backend1.que4;

// SilverPlan class extending HealthInsurancePlan
class SilverPlan extends HealthInsurancePlan {
    public SilverPlan() {
        setCoverage(0.7);
    }

    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        double basePremium = 0.08 * salary;

        if (age > 55) {
            basePremium += 100;
        }
        if (smoking) {
            basePremium += 80;
        }

        return basePremium;
    }
}
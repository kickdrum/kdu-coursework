package org.backend1.que4;


class GoldPlan extends HealthInsurancePlan {
    public GoldPlan() {
        setCoverage(0.8);
    }

    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        double basePremium = 0.08 * salary;
        if (age > 55) {
            basePremium += 150;
        }
        if (smoking) {
            basePremium += 90;
        }

        return basePremium;
    }
}
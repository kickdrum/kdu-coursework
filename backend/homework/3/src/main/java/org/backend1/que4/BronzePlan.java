package org.backend1.que4;


// BronzePlan class extending HealthInsurancePlan
class BronzePlan extends HealthInsurancePlan {
    public BronzePlan() {
        setCoverage(0.6);
    }

    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        double basePremium = 0.08 * salary;

        if (age > 55) {
            basePremium += 50;
        }
        if (smoking) {
            basePremium += 70;
        }

        return basePremium;
    }


}
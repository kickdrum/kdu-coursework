package org.backend1.que3;

/**
 * Class referenced from second question
 */

class GoldPlan extends HealthInsurancePlan {
    public GoldPlan() {
        setCoverage(0.8);
    }

    public double computeMonthlyPremium(double salary){
        double cutfromSalary = (double) 7*(salary) / 100;
        return cutfromSalary;
    }
}
package org.backend1.que3;

/**
 * Class referenced from second question
 */
// SilverPlan class extending HealthInsurancePlan
class SilverPlan extends HealthInsurancePlan {
    public SilverPlan() {
        setCoverage(0.7);
    }

    public double computeMonthlyPremium(double salary){
        double cutfromSalary = (double) 6*(salary) / 100;
        return cutfromSalary;
    }
}
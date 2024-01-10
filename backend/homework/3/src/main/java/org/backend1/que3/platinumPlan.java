package org.backend1.que3;

/**
 * Class referenced from second question
 */
// PlatinumPlan class extending HealthInsurancePlan
class PlatinumPlan extends HealthInsurancePlan {
    public PlatinumPlan() {
        setCoverage(0.9);
    }

    public double computeMonthlyPremium(double salary){
        double cutfromSalary = (double) 8*(salary) / 100;
        return cutfromSalary;
    }

}
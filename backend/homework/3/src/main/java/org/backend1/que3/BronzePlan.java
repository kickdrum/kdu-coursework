package org.backend1.que3;

/**
 * Class referenced from second question
 */
class BronzePlan extends HealthInsurancePlan {
    public BronzePlan() {
        setCoverage(0.6);
    }

    public double computeMonthlyPremium(double salary){
        double cutfromSalary = (double) 5*(salary) / 100;
        return cutfromSalary;
    }
}
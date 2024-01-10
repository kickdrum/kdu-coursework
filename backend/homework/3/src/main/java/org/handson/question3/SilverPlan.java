package org.handson.question3;


import org.handson.question1and2.Constants;

public class SilverPlan extends HealthInsurancePlan {
    private static final double coverage = Constants.SILVER_PLAN;
    private static final double premium = Constants.SILVER_PLAN_PREMIUM;
    public SilverPlan() {
        super(coverage,premium);
    }
    /**
     * Computes the monthly premium based on the given salary.
     *
     * @param  salary	the salary of the individual
     * @return         	the computed monthly premium
     */
    @Override
    double computeMonthlyPremium(double salary) {
        return salary*premium;
    }
}

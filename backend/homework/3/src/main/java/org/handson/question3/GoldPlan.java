package org.handson.question3;

import org.handson.question1and2.Constants;

public class GoldPlan extends HealthInsurancePlan {
    private static final double coverage = Constants.GOLD_PLAN;
    private static final double premium = Constants.GOLD_PLAN_PREMIUM;
    public GoldPlan() {
        super(coverage,premium);
    }
    /**
     * Computes the monthly premium based on the given salary.
     *
     * @param  salary  the salary used to calculate the monthly premium
     * @return         the computed monthly premium
     */
    @Override
    double computeMonthlyPremium(double salary) {
        return salary*premium;
    }
}

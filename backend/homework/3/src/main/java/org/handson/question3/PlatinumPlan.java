package org.handson.question3;

import org.handson.question1and2.Constants;

public class PlatinumPlan extends HealthInsurancePlan {
private static final double coverage = Constants.PLATINUM_PLAN;
    private static final double premium = Constants.PLATINUM_PLAN_PREMIUM;
    public PlatinumPlan() {
        super(coverage,premium);
    }
    /**
     * A description of the entire Java function.
     *
     * @param  salary  description of parameter
     * @return         description of return value
     */
    @Override
    double computeMonthlyPremium(double salary) {
        return salary*premium;
    }
}

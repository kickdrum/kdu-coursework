package org.handson.question4;


import org.handson.question1and2.Constants;

public class SilverPlan extends HealthInsurancePlan {
    private static final double coverage = Constants.SILVER_PLAN;
    private static final double premium = Constants.SILVER_PLAN_PREMIUM;
    public SilverPlan() {
        super(coverage,premium);
    }

    /**
     * A description of the entire Java function.
     *
     * @param  salary    description of parameter
     * @param  age       description of parameter
     * @param  smoking   description of parameter
     * @return           description of return value
     */
    @Override
    double computeMonthlyPremium(double salary,int age, boolean smoking) {
        InsuranceBrand insuranceBrand = getOfferedBy();
        return salary*premium+insuranceBrand.computeMonthlyPremium(this,age,smoking);
    }
}

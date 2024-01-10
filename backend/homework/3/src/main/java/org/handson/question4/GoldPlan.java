package org.handson.question4;

import org.handson.question1and2.Constants;

public class GoldPlan extends HealthInsurancePlan {
    private static final double coverage = Constants.GOLD_PLAN;
    private static final double premium = Constants.GOLD_PLAN_PREMIUM;
    public GoldPlan() {
        super(coverage,premium);
    }

    /**
     * Computes the monthly premium for an insurance policy based on the salary, age, and smoking status of the policyholder.
     *
     * @param  salary   the salary of the policyholder
     * @param  age      the age of the policyholder
     * @param  smoking  true if the policyholder is a smoker, false otherwise
     * @return          the computed monthly premium for the insurance policy
     */
    @Override
    double computeMonthlyPremium(double salary,int age, boolean smoking) {
        InsuranceBrand insuranceBrand = getOfferedBy();
        return salary*premium+insuranceBrand.computeMonthlyPremium(this,age,smoking);
    }
}

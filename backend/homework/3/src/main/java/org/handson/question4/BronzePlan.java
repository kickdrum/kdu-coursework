package org.handson.question4;


import org.handson.question1and2.Constants;

public class BronzePlan extends HealthInsurancePlan {
    private static  double coverage = Constants.BRONZE_PLAN;
    private static  double premium = Constants.BRONZE_PLAN_PREMIUM;

    public BronzePlan() {
        super(coverage,premium);
    }

    /**
     * Computes the monthly premium based on the given salary, age, and smoking status.
     *
     * @param salary   the salary of the individual
     * @param age      the age of the individual
     * @param smoking  indicates if the individual is a smoker
     * @return         the computed monthly premium
     */
    @Override
    double computeMonthlyPremium(double salary,int age, boolean smoking) {
        InsuranceBrand insuranceBrand = getOfferedBy();
        return salary*premium+insuranceBrand.computeMonthlyPremium(this,age,smoking);
    }
}

package org.example.ques3and4.billingComponent;

public class BlueCrossBlueShield implements InsuranceBrand{
    @Override
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking) {
        double premium = 0.0;

        if (insurancePlan instanceof PlatinumPlan) {
            if(age>55){
                premium=200.0;
            }
            if(smoking){
                premium+=100.0;
            }
        }
        if (insurancePlan instanceof GoldPlan) {
            if(age>55){
                premium=150.0;
            }
            if(smoking){
                premium+=90.0;
            }
        }
        if (insurancePlan instanceof SilverPlan) {
            if(age>55){
                premium=100.0;
            }
            if(smoking){
                premium+=80.0;
            }
        }
        if (insurancePlan instanceof BronzePlan) {
            if(age>55){
                premium=50.0;
            }
            if(smoking){
                premium+=70.0;
            }
        }
        return premium;
    }
}

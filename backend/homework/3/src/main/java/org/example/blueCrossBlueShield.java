package org.example;

public class blueCrossBlueShield implements insuranceBrand {
    public double computeMonthlyPremium(healthInsurancePlan insurancePlan, int age, boolean smoking){
        double premium = 0;
        if(insurancePlan instanceof platinumPlan) {
            if (age > 55) {
                premium = premium + 200.0;
            }
            if (smoking) {
                premium = premium + 100.0;
            }
        }

        else if(insurancePlan instanceof goldPlan){
            if (age > 55) {
                premium = premium + 150.0;
            }
            if (smoking) {
                premium = premium + 90.0;
            }
        }

        else if(insurancePlan instanceof silverPlan){
            if (age > 55) {
                premium = premium + 50.0;
            }
            if (smoking) {
                premium = premium + 80.0;
            }
        }

        else if(insurancePlan instanceof bronzePlan){
            if (age > 55) {
                premium = premium + 50.0;
            }
            if (smoking) {
                premium = premium + 70.0;
            }
        }

        return premium;
    }
}
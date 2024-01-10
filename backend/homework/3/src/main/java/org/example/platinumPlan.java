package org.example;

public class platinumPlan extends healthInsurancePlan {
    public platinumPlan(){
        setCoverage(0.9);
    }

    public double computeMonthlyPremium(double salary, int age, boolean smoking){
        return 0.08 * salary + getOfferedBy().computeMonthlyPremium(this,age,smoking);
    }
}
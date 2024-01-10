package org.example;

public class silverPlan extends healthInsurancePlan {
    public silverPlan(){
        setCoverage(0.7);
    }
    public double computeMonthlyPremium(double salary, int age, boolean smoking){
        return 0.06 * salary + getOfferedBy().computeMonthlyPremium(this,age,smoking);
    }
}

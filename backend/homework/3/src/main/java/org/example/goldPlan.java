package org.example;

public class goldPlan extends healthInsurancePlan {
    public goldPlan(){
        setCoverage(0.8);
    }
    public double computeMonthlyPremium(double salary, int age, boolean smoking){
        return 0.07 * salary + getOfferedBy().computeMonthlyPremium(this,age,smoking);
    }
}

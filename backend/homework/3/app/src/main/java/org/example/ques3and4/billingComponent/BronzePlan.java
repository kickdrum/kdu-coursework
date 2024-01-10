package org.example.ques3and4.billingComponent;

public class BronzePlan extends HealthInsurancePlan {
    public BronzePlan() {
        setCoverage(0.6);
    }


    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.05 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
}

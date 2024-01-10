package org.example.BillingComponent;
public class SilverPlan extends HealthInsurancePlan {
    public SilverPlan() {
        setCoverage(0.7);
    }
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.06 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
    }

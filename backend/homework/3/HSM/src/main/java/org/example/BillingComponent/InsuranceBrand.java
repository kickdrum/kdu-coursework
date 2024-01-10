package org.example.billingcomponent;

public interface InsuranceBrand {
    double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking);
}


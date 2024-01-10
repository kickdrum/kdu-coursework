package org.example.BillingComponent;

public interface InsuranceBrand {
    double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking);
}


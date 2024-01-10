package org.example.HMS;

public interface InsuranceBrand {
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking);
}
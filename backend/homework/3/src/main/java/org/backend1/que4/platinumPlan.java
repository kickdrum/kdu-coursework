package org.backend1.que4;

// PlatinumPlan class extending HealthInsurancePlan
class PlatinumPlan extends HealthInsurancePlan {
    public PlatinumPlan() {
        setCoverage(0.9);
    }

    public double computeMonthlyPremium(double salary, int age,
                                        boolean smoking) {
        return 0.08 * salary +
                getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }

}
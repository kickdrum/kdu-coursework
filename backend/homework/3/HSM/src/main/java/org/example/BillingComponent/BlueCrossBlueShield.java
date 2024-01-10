package org.example.BillingComponent;


public class BlueCrossBlueShield implements InsuranceBrand {
    @Override
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking) {
        double additionalPremium = 0;

        if (age > 55) {
            if (insurancePlan instanceof PlatinumPlan) {
                additionalPremium += 200;
            } else if (insurancePlan instanceof GoldPlan) {
                additionalPremium += 150;
            } else if (insurancePlan instanceof SilverPlan) {
                additionalPremium += 100;
            } else if (insurancePlan instanceof BronzePlan) {
                additionalPremium += 50;
            }
        }

        if (smoking) {
            additionalPremium += (insurancePlan instanceof PlatinumPlan) ? 100 :
                    (insurancePlan instanceof GoldPlan) ? 90 :
                            (insurancePlan instanceof SilverPlan) ? 80 : 70;
        }

        return additionalPremium;
    }
}

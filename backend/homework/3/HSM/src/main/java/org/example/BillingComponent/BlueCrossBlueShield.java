package org.example.billingcomponent;


public class BlueCrossBlueShield implements InsuranceBrand {

    @Override
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking) {
        double additionalPremium = 0;

        if (age > 55) {
            if (insurancePlan instanceof PlatinumPlan) {
                additionalPremium =additionalPremium+ 200;
            } else if (insurancePlan instanceof GoldPlan) {
                additionalPremium =additionalPremium+ 150;
            } else if (insurancePlan instanceof SilverPlan) {
                additionalPremium =additionalPremium+ 100;
            } else if (insurancePlan instanceof BronzePlan) {
                additionalPremium =additionalPremium+ 50;
            }
        }

        if (smoking) {
            int smokingAdditionalPremium = 70;

            if (insurancePlan instanceof PlatinumPlan) {
                smokingAdditionalPremium = 100;
            } else if (insurancePlan instanceof GoldPlan) {
                smokingAdditionalPremium = 90;
            } else if (insurancePlan instanceof SilverPlan) {
                smokingAdditionalPremium = 80;
            }

            additionalPremium += smokingAdditionalPremium;
        }

        return additionalPremium;
    }
}

package org.example;

import org.example.BillingComponent.BlueCrossBlueShield;
import org.example.BillingComponent.HealthInsurancePlan;
import org.example.BillingComponent.InsuranceBrand;
import org.example.BillingComponent.PlatinumPlan;
import org.example.HSM.Staff;
import org.example.HSM.User;

public class Main {
    public static void main(String[] args) {
        User staff = new Staff();
        InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
        HealthInsurancePlan insurancePlan = new PlatinumPlan();

        insurancePlan.setOfferedBy(insuranceBrand);
        staff.setInsurancePlan(insurancePlan);
        double premium = insurancePlan.computeMonthlyPremium(5000, 60, true);

        System.out.println("Monthly Premium: " + premium);
    }
}


package org.example.ques3and4.hospitalMangementSystem;

import org.example.Log;
import org.example.ques1and2.hospitalMangementSystem.Doctor;
import org.example.ques3and4.billingComponent.BlueCrossBlueShield;
import org.example.ques3and4.billingComponent.HealthInsurancePlan;
import org.example.ques3and4.billingComponent.InsuranceBrand;
import org.example.ques3and4.billingComponent.PlatinumPlan;

public class Main {
    public static void main(String[] args) {
        User staff = new User();
        InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
        HealthInsurancePlan insurancePlan = new PlatinumPlan();

        insurancePlan.setOfferedBy(insuranceBrand);
        staff.setInsurancePlan(insurancePlan);
        Log.logger.info("The monthly premium is {}", insurancePlan.computeMonthlyPremium(5000, 56, true));
    }
}

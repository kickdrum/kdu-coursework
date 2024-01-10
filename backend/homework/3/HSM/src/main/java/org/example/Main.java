package org.example;

import org.example.billingcomponent.*;
import org.example.hsm.Staff;
import org.example.hsm.User;
import org.example.logging.LoggingSystem;

public class Main {
    public static void main(String[] args) {
       final LoggingSystem ls = new LoggingSystem();

                HealthInsurancePlan insurancePlan = new PlatinumPlan();


        User staff = new Staff();
        InsuranceBrand insuranceBrand1 = new BlueCrossBlueShield();
        HealthInsurancePlan insurancePlan1 = new PlatinumPlan();

        insurancePlan.setOfferedBy(insuranceBrand1);
        staff.setInsurancePlan(insurancePlan);
        ls.logInfo("Monthly insurance premium : " +  insurancePlan.computeMonthlyPremium(5000, 56, true)+ " $");
    }
}


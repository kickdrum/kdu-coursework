package org.handson.question4;

public class Main {
    public static void main(String[] args) {
        User staff = new User();
        InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        insurancePlan.setOfferedBy(insuranceBrand);
        staff.setInsurancePlan(insurancePlan);
        MyLogger.customLogger("Amount Paid By Insurance Company: "+insurancePlan.computeMonthlyPremium(5000, 56, true),"INFO");

    }
}
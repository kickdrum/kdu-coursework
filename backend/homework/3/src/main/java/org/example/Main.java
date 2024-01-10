package org.example;

public class Main {
    private static logger log = new logger();
    public static void main(String[] args) {
        healthInsurancePlan insurancePlan = new platinumPlan();

        patient patientA = new patient();
        patientA.setInsurancePlan(insurancePlan);

        double[] payments = billing.computePaymentAmount(patientA, 1000.0);
        log.logInfo(String.valueOf(payments[0]));
        log.logInfo(String.valueOf(payments[1]));

        user staff = new user();
        insuranceBrand insuranceBrand = new blueCrossBlueShield();

        insurancePlan.setOfferedBy(insuranceBrand);
        staff.setInsurancePlan(insurancePlan);
        log.logInfo("Result : " + insurancePlan.computeMonthlyPremium(5000, 56, true));

    }
}
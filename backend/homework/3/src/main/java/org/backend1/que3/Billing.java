package org.backend1.que3;

public class Billing {
    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();


        if (patientInsurancePlan != null) {
            double insuranceCoverage = amount * patientInsurancePlan.getCoverage();
            double discount = 0;

            if (patientInsurancePlan instanceof PlatinumPlan) {
                discount = 50;
            } else if (patientInsurancePlan instanceof GoldPlan) {
                discount = 40;
            } else if (patientInsurancePlan instanceof SilverPlan) {
                discount = 30;
            } else if (patientInsurancePlan instanceof BronzePlan) {
                discount = 25;
            }
            payments[0] = insuranceCoverage;
            payments[1] = insuranceCoverage - discount;
        } else {
            payments[0] = 0;
            payments[1] = amount - 20;
        }

        return payments;
    }
}

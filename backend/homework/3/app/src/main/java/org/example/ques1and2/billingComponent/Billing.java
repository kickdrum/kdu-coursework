package org.example.ques1and2.billingComponent;

import org.example.ques1and2.hospitalMangementSystem.Patient;

public class Billing {
    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();
        if (patientInsurancePlan != null) {
            double coverage = patientInsurancePlan.getCoverage();
            payments[0] = amount * coverage;
            payments[1] = amount - payments[0];
        } else {
            payments[0] = 0.0;
            payments[1] = amount;
        }
        double discount = 20.0;
        if (patientInsurancePlan instanceof PlatinumPlan) {
            discount = 50.0;
        } else if (patientInsurancePlan instanceof GoldPlan) {
            discount = 40.0;
        } else if (patientInsurancePlan instanceof SilverPlan) {
            discount = 30.0;
        } else if (patientInsurancePlan instanceof BronzePlan) {
            discount = 25.0;
        }

        payments[1] = payments[1] - discount;
        if (payments[1] < 0) {
            payments[1] = 0.0;
        }



        return payments;
    }
}

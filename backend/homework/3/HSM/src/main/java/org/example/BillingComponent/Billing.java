package org.example.billingcomponent;

import org.example.hsm.Patient;

public class Billing extends Patient{
    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

        if (patientInsurancePlan != null) {
            double insuranceCoverage = patientInsurancePlan.getCoverage();
            double insurancePayment = amount * insuranceCoverage;
            double patientPayment = amount - insurancePayment;


            if (patientInsurancePlan instanceof PlatinumPlan) {
                patientPayment -= 50;
            } else if (patientInsurancePlan instanceof GoldPlan) {
                patientPayment -= 40;
            } else if (patientInsurancePlan instanceof SilverPlan) {
                patientPayment -= 30;
            } else if (patientInsurancePlan instanceof BronzePlan) {
                patientPayment -= 25;
            }

            payments[0] = insurancePayment;
            payments[1] = patientPayment;
        } else {

            payments[0] = 0;
            payments[1] = amount - 20;
        }

        return payments;
    }
}
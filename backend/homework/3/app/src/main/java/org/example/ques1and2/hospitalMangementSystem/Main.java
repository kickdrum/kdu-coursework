package org.example.ques1and2.hospitalMangementSystem;

import org.example.Log;
import org.example.ques1and2.billingComponent.Billing;
import org.example.ques1and2.billingComponent.GoldPlan;
import org.example.ques1and2.billingComponent.HealthInsurancePlan;

public class Main {
    public static void main(String[] args) {
        HealthInsurancePlan insurancePlan = new GoldPlan();
        Patient patient = new Patient();
        patient.setInsurancePlan(insurancePlan);
        double[] payments = Billing.computePaymentAmount(patient, 1000.0);

        Log.logger.info("%nInsurance Company Amount : {} \nPatient Amount : {}",payments[0],payments[1]);

    }
}

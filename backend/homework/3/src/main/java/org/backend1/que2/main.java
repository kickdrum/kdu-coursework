package org.backend1.que2;

/**
 * Class referenced from second question
 */
public class main {

    public static void main(String args[]) {
        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        Patient patient = new Patient();
        patient.setInsurancePlan(insurancePlan);

        double[] payments = Billing.computePaymentAmount(patient, 1000.0);
        for(int i = 0; i < payments.length; i++){
            System.out.println(payments[i]);
        }
    }
}

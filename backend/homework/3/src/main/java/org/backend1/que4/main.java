package org.backend1.que4;


public class main {
    /**
     * @param args
     */
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

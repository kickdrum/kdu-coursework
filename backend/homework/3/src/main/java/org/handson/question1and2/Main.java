package org.handson.question1and2;
    /**
     * A description of the main function.
     *
     */
public class Main {
    public static void main(String[] args) {
        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        Patient patient = new Patient();
        patient.setInsurancePlan(insurancePlan);

        double[] payments = Billing.computePaymentAmount(patient, 1000.0);
        MyLogger.customLogger("Amount Paid By Insurance Company: "+payments[0],"INFO");
        MyLogger.customLogger("Amount Paid By Patient: "+payments[1],"INFO");
    }
}
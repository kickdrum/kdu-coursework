package org.handson.question3;

public class Main {
        /**
     * Executes the main method of the Java program.
     *
     * @param  args	an array of command-line arguments passed to the program
     */
    public static void main(String[] args) {
        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        Patient patient = new Patient();
        patient.setInsurancePlan(insurancePlan);

        double[] payments = Billing.computePaymentAmount(patient, 1000.0);
        MyLogger.customLogger("Amount Paid By Insurance Company: "+payments[0],"INFO");
        MyLogger.customLogger("Amount Paid By Patient: "+payments[1],"INFO");
    }
}
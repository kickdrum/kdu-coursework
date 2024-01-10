package org.handson.question3;

public class Billing {
        /**
     * Computes the payment amount for a given patient and amount.
     *
     * @param  patient  the patient for whom the payment is being computed
     * @param  amount   the amount to be paid
     * @return          an array of two doubles representing the payment amounts
     */
    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();
        if (patientInsurancePlan == null) {
            MyLogger.customLogger("Patient does not have an insurance plan", "ERROR");
            payments[0] = 0;
            payments[1] = amount-20;

        } else {
            Double coverage = patientInsurancePlan.getCoverage();
            payments[0] = amount * coverage;
            payments[1] = amount - payments[0];
            String coverageString = coverage.toString();
            switch (coverageString)
            {
                case "0.9"->payments[1]-=50;
                case "0.8"->payments[1]-=40;
                case "0.7"->payments[1]-=30;
                case "0.6"->payments[1]-=25;

            }
        }
        return payments;

    }
}
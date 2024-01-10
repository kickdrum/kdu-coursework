package org.backend1.que3;
import java.util.logging.Logger;

/**
 * Class referenced from second question
 */
public class main {
    /**
     * @param args
     */

    private static final Logger LOGGER = Logger.getLogger(main.class.getName());

    public static void main(String args[]) {
        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        Patient patient = new Patient();
        patient.setInsurancePlan(insurancePlan);

        double[] payments = Billing.computePaymentAmount(patient, 1000.0);

        for(int i = 0; i < payments.length; i++){
            LOGGER.info(String.valueOf(payments[i]));
        }
    }
}

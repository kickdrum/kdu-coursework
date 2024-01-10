package billing;

import org.example.Logging;
import org.example.Patient;

public class Main {

    public static Logging logging = new Logging();
    public static void logStatement(double first,double second){
        logging.logString(String.format("Amount to be paid by company: %s Amount to be paid by patient: %s\n", first, second));

    }
    public static void main(String[] args) {


        //Creating a patient for demonstration
        Patient patient = new Patient();
        patient.setPatientId(52);
        patient.setEmail("sasi.rachapotu@gmail.com");
        patient.setId(1);
        patient.setGender("Male");
        patient.setFirstName("Sasi");
        patient.setLastname("Rachapotu");

        StringBuilder details = new StringBuilder("Patient details: ");
        details.append("Firstname: ");
        details.append(patient.getFirstName());
        details.append((" Email: "));
        details.append(patient.getEmail());
        details.append(" PatientId: ");
        details.append(patient.getPatientId());


        logging.logString(details);

        // Setting platinum insurance plan
        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        patient.setInsurancePlan(insurancePlan);

        //Payment amount for platinum plan
        double[] payments = Billing.computePaymentAmount(patient, 1000.0);
        logging.logString("Payment for Platinum\n");
        logStatement(payments[0],payments[1]);

        //Payment for gold plan
        insurancePlan = new GoldPlan();
        patient.setInsurancePlan(insurancePlan);

        payments = Billing.computePaymentAmount(patient, 1000.0);
        logging.logString("Payment for Gold\n");
        logStatement(payments[0],payments[1]);

        //Payment for Silver Plan
        insurancePlan = new SilverPlan();
        patient.setInsurancePlan(insurancePlan);

        payments = Billing.computePaymentAmount(patient, 1000.0);
        logging.logString("Payment for Silver\n");
        logStatement(payments[0],payments[1]);

        //Payment for Bronze plan
        insurancePlan = new BronzePlan();
        patient.setInsurancePlan(insurancePlan);

        payments = Billing.computePaymentAmount(patient, 1000.0);
        logging.logString("Payment for Bronze\n");
        logStatement(payments[0],payments[1]);

    }
}

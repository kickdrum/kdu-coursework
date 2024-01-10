package question2;

public class Billing{

    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];
        double discount=0.0;
        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();
        // your logic

        double coverage=patientInsurancePlan.getCoverage();

        double insuranceAmount=amount * coverage;
        discount= patientInsurancePlan.getDiscount();
        if(patient.getInsurancePlan()!=null) {

            payments[0]=insuranceAmount;
            payments[1]=amount-insuranceAmount-discount;
        }
        else{
            payments[0]=0.0;
            payments[1]=amount-20;
        }

        return payments;
    }
}

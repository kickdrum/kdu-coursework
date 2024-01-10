package backend.hw3.hms;

public class BillingComponent {
    /**
     *this method is calculating the billing amount based on the premium plans and the discount we are getting through that plan.
     * @param patient
     * @param amount
     * @return payments(what the user has to pay)
     */
    public static double[] computeBillingAmount(Patient patient,double amount){
        double[] payments = new double[2];

        double discount=0.0;
        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();
        double coverage=patientInsurancePlan.getCoverage();
        double insuranceAmount=amount * coverage;
        if(patient.getInsurancePlan()!=null) {
            if (patientInsurancePlan instanceof Platinum) {
                discount = 50.0;
            } else if (patientInsurancePlan instanceof Gold) {
                discount = 40.0;
            } else if (patientInsurancePlan instanceof Silver) {
                discount = 30.0;
            } else if (patientInsurancePlan instanceof Bronze) {
                discount = 25.0;
            }
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

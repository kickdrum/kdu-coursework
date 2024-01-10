package shrishti.example.BillingComponent;
import shrishti.example.BillingComponent.Patient;
public class Billing {

    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];
        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();
        double amountInsurancePaid = 0;
        double amountPatientPaid=0;
        if(patientInsurancePlan instanceof PlatinumPlan || patientInsurancePlan instanceof BronzePlan || patientInsurancePlan instanceof GoldPlan || patientInsurancePlan instanceof SilverPlan){
            amountInsurancePaid=amount* patientInsurancePlan.getCoverage();
            amountPatientPaid=amount-amountInsurancePaid - patientInsurancePlan.getDiscount();

        }else{
            amountInsurancePaid=0;
            amountPatientPaid=amount-20;
        }
        payments[0]=amountInsurancePaid;
        payments[1]= amountPatientPaid;
        // your logic
        return payments;
    }
    // payments{amount to be paid by insurance, amount paid by patient}
}

package billing;

import org.example.Patient;

public class Billing {

    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];

        try{
            HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

            double companyAmount = amount * patientInsurancePlan.getCoverage();
            double patientamount = amount - companyAmount;
            if(patientInsurancePlan instanceof PlatinumPlan){
                patientamount -=50;
            }
            else if(patientInsurancePlan instanceof  GoldPlan){
                patientamount-=40;
            }else if(patientInsurancePlan instanceof  SilverPlan){
                patientamount-=30;
            }else if(patientInsurancePlan instanceof  BronzePlan){
                patientamount-=25;
            }
            else{
                patientamount-=20;
            }

            payments[0]=companyAmount;
            payments[1]=patientamount;

            return payments;
        }
        catch(NullPointerException E){
            System.out.println("No plan exists for the user so default rates applied");
            payments[0]=0;
            payments[1]=amount-20;
        }


        return payments;

    }
}

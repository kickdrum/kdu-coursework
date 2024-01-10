package org.example.HMS;

public class Billing {

    public static double[] computePaymentAmount(Patient patient, double amount){
        double[] payments = new double[2];
        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();
        if(patientInsurancePlan != null){
            double coverage = patientInsurancePlan.getCoverage();
            double insuranceCoveredAmount = amount * coverage;
            double patientPayment = amount - insuranceCoveredAmount;

            if(patientInsurancePlan instanceof PlatinumPlan){
                patientPayment -= 50;
            }
            else if(patientInsurancePlan instanceof GoldPlan){
                patientPayment -= 40;
            }
            else if(patientInsurancePlan instanceof SilverPlan){
                patientPayment -= 30;
            }
            else if(patientInsurancePlan instanceof BronzePlan){
                patientPayment -= 25;
            }

            payments[0] = insuranceCoveredAmount;
            payments[1] = Math.max(0, patientPayment);
        }
        else{
            payments[0] = 0;
            payments[1] = Math.max(0, amount - 20);
        }
        return payments;
    }
}
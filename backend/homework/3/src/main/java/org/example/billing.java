package org.example;
public class billing {
    public static double[] computePaymentAmount(patient patient, double amount) {
        double[] payments = new double[2];

        healthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

        if(patientInsurancePlan == null){
            payments[0] = 20;
            payments[1] = amount - 20;
            return payments;
        }

        double patientInsurancePlanCoverage = patientInsurancePlan.getCoverage();
        double patientPaymentAmount = amount*(1-patientInsurancePlanCoverage);

        if(patientInsurancePlanCoverage == 0.9){
            patientPaymentAmount = patientPaymentAmount - 50;
        }
        else if(patientInsurancePlanCoverage == 0.8){
            patientPaymentAmount = patientPaymentAmount - 40;
        }
        else if(patientInsurancePlanCoverage == 0.7){
            patientPaymentAmount = patientPaymentAmount - 30;
        }
        else if(patientInsurancePlanCoverage == 0.6){
            patientPaymentAmount = patientPaymentAmount - 25;
        }

        if(patientInsurancePlanCoverage<0){
            patientPaymentAmount = 0;
        }

        payments[0] = amount - patientPaymentAmount;
        payments[1] = patientPaymentAmount;
        return payments;
    }
}
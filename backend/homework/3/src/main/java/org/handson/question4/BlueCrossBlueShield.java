package org.handson.question4;

public class BlueCrossBlueShield implements InsuranceBrand{
    /**
     * Computes the monthly premium for a given health insurance plan, age, and smoking status.
     *
     * @param  insurancePlan  the health insurance plan
     * @param  age            the age of the individual
     * @param  smoking        the smoking status of the individual
     * @return                the computed monthly premium
     */
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking)
    {
        Double coverage = insurancePlan.getCoverage();
        double premium = 0;
        switch(coverage.toString())
        {
           case "0.9"->{
               if(age>55)
               {
                   premium+=200;
               }
               if(smoking)
               {
                   premium+=100;
               }
           }
            case "0.8"->{
                if(age>55)
                {
                    premium+=150;
                }
                if(smoking)
                {
                    premium+=90;
                }
            }
            case "0.7"->{
                if(age>55)
                {
                    premium+=100;
                }
                if(smoking)
                {
                    premium+=80;
                }
            }
            case "0.6"->{
                if(age>55)
                {
                    premium+=50;
                }
                if(smoking)
                {
                    premium+=70;
                }
            }
            default -> premium=0;

        }
        return premium;
    }
}

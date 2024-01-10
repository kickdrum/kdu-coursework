package backend.hw3.hms;

public class BlueCrossBlueShield implements InsuranceBrand{
    /**
     * We are using this method to compute the monthly premium based on the age and the status of the user smoking and according to that the premium is calculated.
     * @param insurancePlan
     * @param age
     * @param userSmoke
     * @return
     */
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean userSmoke){
        double answer=0.0;
        if(insurancePlan instanceof Platinum){
            if(age>55){
                answer=200.0;
            }
            if(userSmoke){
                answer+=100.0;
            }
        }
        else if(insurancePlan instanceof Gold){
            if(age>55){
                answer=150.0;
            }
            if(userSmoke){
                answer+=90.0;
            }
        }
        else if(insurancePlan instanceof Silver){
            if(age>55){
                answer=100.0;
            }
            if(userSmoke){
                answer+=80.0;
            }
        }
        else if(insurancePlan instanceof Bronze){
            if(age>55){
                answer=50.0;
            }
            if(userSmoke){
                answer+=70.0;
            }
        }
        return answer;
    }

}

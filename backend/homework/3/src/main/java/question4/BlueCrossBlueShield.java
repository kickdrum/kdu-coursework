package question4;

public class BlueCrossBlueShield implements InsuranceBrand{
    /**
     *
     * @param insurancePlan
     * @param age
     * @param userSmoke
     * @return
     */
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean userSmoke){
        double amount=0.0;
        if(insurancePlan instanceof PlatinumPlan){
            if(age>55){
                amount=200.0;
            }
            if(userSmoke){
                amount+=100.0;
            }
        }
        else if(insurancePlan instanceof GoldPlan){
            if(age>55){
                amount=150.0;
            }
            if(userSmoke){
                amount+=90.0;
            }
        }
        else if(insurancePlan instanceof SilverPlan){
            if(age>55){
                amount=100.0;
            }
            if(userSmoke){
                amount+=80.0;
            }
        }
        else if(insurancePlan instanceof BronzePlan){
            if(age>55){
                amount=50.0;
            }
            if(userSmoke){
                amount+=70.0;
            }
        }
        return amount;
    }
}

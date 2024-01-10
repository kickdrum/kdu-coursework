package shrishti.example.BillingComponent;

import java.awt.*;

public class BlueCrossBlueShield implements InsuranceBrand{
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking){
        double answer = 0.0;
        if(insurancePlan instanceof PlatinumPlan){
            if(age>55){
                answer+=200.0;
            }
            if(smoking){
                answer+=100.0;
            }
        }
        if(insurancePlan instanceof GoldPlan){
            if(age>55){
                answer+=150.0;
            }
            if(smoking){
                answer+=90.0;
            }
        }
        if(insurancePlan instanceof SilverPlan){
            if(age>55){
                answer+=100.0;
            }
            if(smoking){
                answer+=80.0;
            }
        }
        if(insurancePlan instanceof BronzePlan){
            if(age>55){
                answer+=50.0;
            }
            if(smoking){
                answer+=70.0;
            }
        }
        return answer;
    }
}

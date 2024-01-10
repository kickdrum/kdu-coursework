package question4;

import question3.*;

public class BlueCrossBlueShield implements InsuranceBrand{

    @Override
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking) {

        if(insurancePlan instanceof Platinum){
            if(age >55){
                if(smoking){
                    return 300;
                }
                else{
                    return 200;
                }
            }
        }
        else if(insurancePlan instanceof Gold){
            if(age>55){
                if(smoking){
                    return 240;
                }
                else{
                    return 150;
                }
            }
        }
        else if(insurancePlan instanceof Silver){
            if(age>55){
                if(smoking){
                    return 180;
                }
                else{
                    return 100;
                }
            }
        }
        else if(insurancePlan instanceof Bronze){
            if(age>55){
                if(smoking){
                    return 120;
                }
                else{
                    return 50;
                }
            }
        }

        return 0;
    }
}

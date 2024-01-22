package question4;

public class SilverPlan extends HealthInsurancePlan {
    public SilverPlan(){
        setCoverage(0.7);
        this.setDiscount(30);
    }

    public double computeMonthlyPremium(double salary,int age,boolean userSmoke){
        return 0.06*salary+ getOfferedBy().computeMonthlyPremium(this, age, userSmoke);
    }
}

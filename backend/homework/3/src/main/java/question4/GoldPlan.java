package question4;


public class GoldPlan extends HealthInsurancePlan {
    public GoldPlan(){
        setCoverage(0.8);
        this.setDiscount(40);
    }
    public double computeMonthlyPremium(double salary,int age,boolean userSmoke){
        return 0.07*salary + getOfferedBy().computeMonthlyPremium(this, age, userSmoke);
    }
}

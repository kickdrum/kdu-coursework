package question4;

public class PlatinumPlan extends HealthInsurancePlan {
    public PlatinumPlan(){
        this.setCoverage(0.9);
        this.setDiscount(50);
    }
    public double computeMonthlyPremium(double salary,int age,boolean userSmoke){
        return 0.08*salary + getOfferedBy().computeMonthlyPremium(this, age, userSmoke);
    }
}

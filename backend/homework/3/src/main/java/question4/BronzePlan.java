package question4;


public class BronzePlan extends HealthInsurancePlan {
    public BronzePlan(){
        setCoverage(0.6);
        this.setDiscount(25);
    }

    public double computeMonthlyPremium(double salary,int age,boolean userSmoke){
        return 0.05*salary+ getOfferedBy().computeMonthlyPremium(this, age, userSmoke);
    }
}

package question3;

public abstract class GoldPlan extends HealthInsurancePlan {
    public GoldPlan(){
        setCoverage(0.8);
        this.setDiscount(40);
    }
}

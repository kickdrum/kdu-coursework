package question3;

public abstract class SilverPlan extends HealthInsurancePlan {
    public SilverPlan(){
        setCoverage(0.7);
        this.setDiscount(30);
    }
}

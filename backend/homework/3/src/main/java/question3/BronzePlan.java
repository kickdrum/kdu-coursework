package question3;

public abstract class BronzePlan extends HealthInsurancePlan {
    public BronzePlan(){
        setCoverage(0.6);
        this.setDiscount(25);
    }
}

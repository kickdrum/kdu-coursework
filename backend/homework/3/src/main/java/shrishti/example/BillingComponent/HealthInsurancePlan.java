package shrishti.example.BillingComponent;

public abstract class HealthInsurancePlan {

    private double coverage;
    private int discount;private int monthlyPremium;
    private InsuranceBrand offeredBy;

    public double getCoverage(){
        return coverage;
    }
    public void setCoverage(double coverage){
        this.coverage=coverage;
    }
    public double getDiscount(){return discount;}
    public void setDiscount(int discount){
        this.discount=discount;
    }

    public abstract double computeMonthlyPremium(double salary,int age, boolean smoking);

    public InsuranceBrand getOfferedBy() {
        return offeredBy;
    }
    public void setOfferedBy(InsuranceBrand offeredBy) {
        this.offeredBy = offeredBy;
    }


}


// premium increase age > 55
// if smokes premium increase
//
package org.example;

public abstract class healthInsurancePlan {
    private insuranceBrand offeredBy;
    private double coverage;
    public healthInsurancePlan(){}
    public healthInsurancePlan(insuranceBrand offeredBy, double coverage){
        this.offeredBy = offeredBy;
        this.coverage = coverage;
    }
    public insuranceBrand getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(insuranceBrand offeredBy) {
        this.offeredBy = offeredBy;
    }

    public double getCoverage(){
        return  coverage;
    }

    public void setCoverage(double coverage){
        this.coverage = coverage;
    }

    public abstract double computeMonthlyPremium(double salary, int age, boolean smoking);

}

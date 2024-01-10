package backend.hw3.hms;

public class Silver extends HealthInsurancePlan{
    public Silver(){
        setCoverage(0.7);
    }
    /**
     * This method is now additionally taking the two new parameters 'age' & 'smoking' too. Below is the implementation of computeMonthlyPremium in Silver.java , getOfferedBy() is from the super class and it would return an instance of InsuranceBrand.
     * @param salary
     * @param age
     * @param userSmoke
     * @return MonthlyPremium
     */
    public double computeMonthlyPremium(double salary,int age,boolean userSmoke){
        return 0.06*salary+ getOfferedBy().computeMonthlyPremium(this, age, userSmoke);
    }
}

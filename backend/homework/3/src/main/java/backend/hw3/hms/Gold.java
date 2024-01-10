package backend.hw3.hms;

public class Gold extends HealthInsurancePlan{
    public Gold(){
        setCoverage(0.8);
    }
    /**
     * This method is now additionally taking the two new parameters 'age' & 'smoking' too. Below is the implementation of computeMonthlyPremium in gold.java, getOfferedBy() is from the super class and it would return an instance of InsuranceBrand.
     * @param salary
     * @param age
     * @param userSmoke
     * @return
     */
    public double computeMonthlyPremium(double salary,int age,boolean userSmoke){
        return 0.07*salary + getOfferedBy().computeMonthlyPremium(this, age, userSmoke);
    }
}

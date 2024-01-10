package backend.hw3.hms;

public class Bronze extends HealthInsurancePlan {
    public Bronze(){
        setCoverage(0.6);
    }
    /**
     * This method is now additionally taking the two new parameters 'age' & 'smoking' too. Below is the implementation of computeMonthlyPremium in Bronze.java, getOfferedBy() is from the super class and it would return an instance of InsuranceBrand.
     * @param salary
     * @param age
     * @param userSmoke
     * @return
     */
    public double computeMonthlyPremium(double salary,int age,boolean userSmoke){
        return 0.05*salary+ getOfferedBy().computeMonthlyPremium(this, age, userSmoke);
    }
}

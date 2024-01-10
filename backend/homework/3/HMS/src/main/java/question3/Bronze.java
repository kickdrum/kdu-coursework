package question3;

public class Bronze extends HealthInsurancePlan{

    public Bronze(){
        setCoverage(0.6);
    }
    @Override
    public double computeMonthlyPremium(double salary) {
        return 0.05*salary;
    }


    // This is for 4th question I have overridden the function to avoid duplicate classes
    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return salary*0.05+getOfferedBy().computeMonthlyPremium(this,age,smoking);
    }
}

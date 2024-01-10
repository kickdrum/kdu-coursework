package question3;


public class Silver extends HealthInsurancePlan{

    public Silver(){
        setCoverage(0.7);
    }
    @Override
    public double computeMonthlyPremium(double salary) {
        return 0.06*salary;
    }

    // This is for 4th question I have overridden the function to avoid duplicate classes
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return salary*0.06+getOfferedBy().computeMonthlyPremium(this,age,smoking);
    }
}

package question3;

public class Platinum extends HealthInsurancePlan{

    public Platinum(){
        setCoverage(0.9);
    }
    @Override
    public double computeMonthlyPremium(double salary) {
        return salary*0.08;
    }

    // This is for 4th question I have overridden the function to avoid duplicate classes
    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return salary*0.08+getOfferedBy().computeMonthlyPremium(this,age,smoking);
    }
}

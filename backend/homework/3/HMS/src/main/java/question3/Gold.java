package question3;


public class Gold extends HealthInsurancePlan{

    public Gold(){
        setCoverage(0.8);
    }
    @Override
    public double computeMonthlyPremium(double salary) {
        return salary *0.07;
    }

    // This is for 4th question I have overridden the function to avoid duplicate classes
    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return salary*0.07+getOfferedBy().computeMonthlyPremium(this,age,smoking);
    }
}

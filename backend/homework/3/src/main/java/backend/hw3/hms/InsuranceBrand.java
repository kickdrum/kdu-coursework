package backend.hw3.hms;

public interface InsuranceBrand{
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking);
}

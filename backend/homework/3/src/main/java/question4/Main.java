package question4;
import java.util.*;
public class Main {
    public static void main(String[] args){
        User user1;
        user1 = new User();
        InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        insurancePlan.setOfferedBy(insuranceBrand);
        user1.setInsurancePlan(insurancePlan);

        double monthlyPremium = insurancePlan.computeMonthlyPremium(5000, 56, true);
        System.out.prinnt(monthlyPremium);
    }
}
package question4;


import org.example.Logging;
import question3.*;

public class Main {
    public static void main(String[] args) {
        User staff = new User();
        InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
        HealthInsurancePlan insurancePlan = new Gold();

        insurancePlan.setOfferedBy(insuranceBrand);
        staff.setInsurancePlan(insurancePlan);

        Logging logging = new Logging();

        logging.logString("The monthly premium according to plan: ");
        logging.logString(Double.toString(insurancePlan.computeMonthlyPremium(5000, 56, true)));
    }
}

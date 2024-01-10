package backend.hw3.hms;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
            User staff = new User();
            InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
            HealthInsurancePlan insurancePlan = new Platinum();
            insurancePlan.setOfferedBy(insuranceBrand);
            staff.setInsurancePlan(insurancePlan);

            double monthlyPremium = insurancePlan.computeMonthlyPremium(5000, 56, true);

            LOGGER.info(String.format("Computed monthly premium: %.2f", monthlyPremium));

    }
}

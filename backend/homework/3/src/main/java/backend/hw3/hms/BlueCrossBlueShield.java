/**
 * Calculates the monthly premium based on the health insurance plan, age, and smoking status.
 *
 * @param insurancePlan The health insurance plan.
 * @param age The age of the individual.
 * @param userSmoke Indicates whether the individual smokes.
 * @return The computed monthly premium.
 */
public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean userSmoke) {
    double answer = 0.0;

    if (insurancePlan instanceof Platinum) {
        answer = 200.0;
    } else if (insurancePlan instanceof Gold) {
        answer = 150.0;
    } else if (insurancePlan instanceof Silver) {
        answer = 100.0;
    } else if (insurancePlan instanceof Bronze) {
        answer = 50.0;
    }

    if (age > 55) {
        answer += calculateAgeSurcharge(insurancePlan, age);
    }

    if (userSmoke) {
        answer += calculateSmokeSurcharge(insurancePlan);
    }

    return answer;
}

/**
 * Calculates the age surcharge based on the health insurance plan and age.
 *
 * @param insurancePlan The health insurance plan.
 * @param age The age of the individual.
 * @return The calculated age surcharge.
 */
private double calculateAgeSurcharge(HealthInsurancePlan insurancePlan, int age) {
    // Age surcharge logic based on insurance plan can be added here
    // For now, a general age surcharge is returned
    return 50.0;
}

/**
 * Calculates the smoke surcharge based on the health insurance plan.
 *
 * @param insurancePlan The health insurance plan.
 * @return The calculated smoke surcharge.
 */
private double calculateSmokeSurcharge(HealthInsurancePlan insurancePlan) {
    // Smoke surcharge logic based on insurance plan can be added here
    // For now, a general smoke surcharge is returned
    return 70.0;
}

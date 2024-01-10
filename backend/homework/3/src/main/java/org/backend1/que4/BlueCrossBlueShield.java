package org.backend1.que4;

public class BlueCrossBlueShield implements InsuranceBrand{

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking) {
        double premium = 0.0;

        if (age > 55) {
            premium += 50;
        }

        if (smoking) {
            premium += 20;
        }

        if (insurancePlan instanceof PlatinumPlan) {
            premium += 200;
            if (smoking) {
                premium += 100;
            }
        } else if (insurancePlan instanceof GoldPlan) {
            premium += 150;
            if (smoking) {
                premium += 90;
            }
        } else if (insurancePlan instanceof SilverPlan) {
            premium += 100;
            if (smoking) {
                premium += 80;
            }
        } else if (insurancePlan instanceof BronzePlan) {
            premium += 50;
            if (smoking) {
                premium += 70;
            }
        }

        return premium;
    }

}

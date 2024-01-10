package org.handson.question1and2;

public class GoldPlan extends HealthInsurancePlan{
    private static final double coverage = Constants.GOLD_PLAN;
    public GoldPlan() {
        super(coverage);
    }
}

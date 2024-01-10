package shrishti.example.BillingComponent;

public class BronzePlan extends HealthInsurancePlan{
    @Override
    public double computeMonthlyPremium(double salary,int age, boolean smoking) {
        return 0.05 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }

    BronzePlan(){
        this.setCoverage(0.6);
        this.setDiscount(25);

    }
}


// Platinum plan has the highest coverage of 0.9, i.e.
// , it covers 90% of the total medical expenses and the
// patient would pay the remaining 10%. So,
// if the total medical expense was $1000,
// then the insurance company would pay $900 ($1000 * 0.9)
// while the patient would pay the remaining $100. The coverage offered by
// GoldPlan, SilverPlan, and BronzePlan are 0.8, 0.7, and 0.6 respectively
// Corresponding getter (getCoverage) & setter (setCoverage)
// should also be provided for 'coverage'.
//Making 'coverage' and its getter & setter part of HealthInsurancePlan and not part o
// f its sub-classes would help avoid code duplication (a benefit of inheritance).
//ext, you need to add a new field called ‘insurancePlan’, which is of type HealthInsurancePlan to the Patient class - null
//This field 'insurancePlan' would be set by setter (setInsurancePlan) and also has corresponding getter (getInsurancePlan).
//getter would have a return type of HealthInsurancePlan while setter would have a parameter whose type is HealthInsurancePlan

//Next, you would implement the billing logic, which goes into a new class called Billing.java, which would have a single static method called computePaymentAmount

// billed after treatement
//
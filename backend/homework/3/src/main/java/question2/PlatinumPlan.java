package question2;

//Platinum plan has the highest coverage of 0.9, i.e., it covers 90% of the total
// medical expenses and the patient would pay the remaining 10%. So, if the total
// medical expense was $1000, then the insurance company would pay $900 ($1000 * 0.9) while
// the patient would pay the remaining $100.
public class PlatinumPlan extends HealthInsurancePlan{

    public PlatinumPlan(){
        this.setCoverage(0.9);
        this.setDiscount(50);
    }

}

package question3;

public class User {
    private long id;
    // added rest of the variables
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    //the staff will also have an insurance hence two new fields are added.
    private Boolean insured;
    private HealthInsurancePlan insurancePlan;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    // add rest of the getters & setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //getter and setter for insured and insurance plan.
    public Boolean getInsured() {
        return insured;
    }
    public void setInsured(Boolean insured) {
        this.insured = insured;
    }

    public HealthInsurancePlan getInsurancePlan() {
        return insurancePlan;
    }
    public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
        this.insurancePlan = insurancePlan;
    }
}

package shrishti.example.BillingComponent;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//




public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private HealthInsurancePlan insurancePlan = null;
    private boolean insured;
    private boolean smokes;
    private int age;


    public long id() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String firstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getSmokes() {
        return this.smokes;
    }

    public void setSmokes(boolean smokes) {
        this.smokes = smokes;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public HealthInsurancePlan getInsurancePlan() {
        return this.insurancePlan;
    }

    public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
        this.insurancePlan = insurancePlan;
    }

    public boolean getInsured() {
        return this.insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }
}

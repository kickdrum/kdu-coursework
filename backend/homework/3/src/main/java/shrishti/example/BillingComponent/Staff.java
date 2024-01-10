package shrishti.example.BillingComponent;//




public class Staff extends User {
    private long staffId;
    private int yearOfExperience;
    private String description;
    private double salary;
    private int premium;

    public Staff() {
    }

    public long getId() {
        return this.staffId;
    }

    public void setId(long staffId) {
        this.staffId = staffId;
    }

    public int getYearOfExperience() {
        return this.yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getPremium() {
        return this.premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }
}

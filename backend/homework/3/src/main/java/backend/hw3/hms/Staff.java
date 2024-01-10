package backend.hw3.hms;

public class Staff extends User{
    private long staffId;
    private int yearsOfExperience;
    private String experience;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public long getStaffId() {
        return staffId;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getExperience() {
        return experience;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

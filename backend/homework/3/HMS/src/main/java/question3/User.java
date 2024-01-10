package question3;


public class User {
        private long id;
        private String firstName;
        private String lastname;
        private String gender;
        private String email;

        private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    private boolean smoking;

    private boolean insurance;

    private HealthInsurancePlan insurancePlan;

        public void setId(long id) {
            this.id = id;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public long getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastname() {
            return lastname;
        }

        public String getGender() {
            return gender;
        }

        public String getEmail() {
            return email;
        }

        public boolean isInsurance() {
        return insurance;
    }
        public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }
        public HealthInsurancePlan getInsurancePlan() {
        return insurancePlan;
        }
        public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
        this.insurancePlan = insurancePlan;
        }
}

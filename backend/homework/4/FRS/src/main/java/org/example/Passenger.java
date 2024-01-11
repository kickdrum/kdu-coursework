package org.example;

public class Passenger {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String gender;
    private final String travelClass;
    private final String confirmationNumber;

    public Passenger(String firstName, String lastName, int age, String gender, String travelClass,
                     String confirmationNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.travelClass = travelClass;
        this.confirmationNumber = confirmationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getTravelClass() {
        return travelClass;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }


    @Override
    public String toString() {
        return String.format("Passenger{firstName='%s', lastName='%s', age=%d, gender='%s', travelClass='%s', confirmationNumber='%s'}%n",
                firstName, lastName, age, gender, travelClass, confirmationNumber);
    }

}


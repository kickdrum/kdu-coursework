package org.handson.question4;

public class User {

    private String firstName;
    private int age;
    private boolean doesSmoke;
    private String lastName;
    private boolean insured;

    private HealthInsurancePlan healthInsurancePlan;


    private String gender;

    private String email;
    private long id;
 /**
     * Retrieves the ID of the object.
     *
     * @return the ID of the object
     */
    public long getId() {
        return id;
    }
        /**
     * Sets the ID of the object.
     *
     */
    public void setId(long id) {
        this.id = id;
    }
 /**
     * Retrieves the first name.
     *
     * @return  the first name
     */
    public String getFirstName() {
        return firstName;
    }
/**
     * Sets the first name of the object.
     *
     * @param  firstName  the new first name to be set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 /**
     * Retrieves the last name of the object.
     *
     * @return the last name of the object
     */
    public String getLastName() {
        return lastName;
    }
 /**
     * Sets the last name of a person.
     *
     * @param  lastName  the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the gender of the person.
     *
     * @return          the gender of the person
     */
    public String getGender() {
        return gender;
    }
/**
     * Sets the gender of the object.
     *
     * @param  gender  the gender to set 
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
 /**
     * Returns the email associated with this object.
     *
     * @return  the email associated with this object
     */
    public String getEmail() {
        return email;
    }
   /**
     * Sets the email address.
     *
     * @param  email  the email address to be set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Returns whether the object is insured or not.
     *
     * @return  true if the object is insured, false otherwise
     */
    public boolean isInsured() {
        return insured;
    }
/**
     * Sets the value of the 'insured' property.
     *
     * @param  insured  the new value for the 'insured' property
     */
    public void setInsured(boolean insured) {
        this.insured = insured;
    }


    /**
     * Retrieves the health insurance plan associated with this object.
     *
     * @return the health insurance plan
     */
    public HealthInsurancePlan getInsurancePlan() {
        return healthInsurancePlan;
    }
    /**
     * Sets the health insurance plan for the user.
     *
     * @param  healthInsurancePlan  the health insurance plan to set
     */

    public void setInsurancePlan(HealthInsurancePlan healthInsurancePlan) {
        this.healthInsurancePlan = healthInsurancePlan;
    }

    /**
     * Retrieves the age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the object.
     *
     * @param  age  the new age value
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the value of the doesSmoke variable.
     *
     * @return  true if the object smokes, false otherwise
     */
    public boolean isDoesSmoke() {
        return doesSmoke;
    }

    /**
     * Sets the value of the "doesSmoke" property.
     *
     * @param doesSmoke the new value for the "doesSmoke" property
     */
    public void setDoesSmoke(boolean doesSmoke) {
        this.doesSmoke = doesSmoke;
    }
}
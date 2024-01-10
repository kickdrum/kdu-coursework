package org.handson.question1and2;
public class User {

    private String firstName;

    private String lastName;

    private String gender;

    private String email;
    private long id;
  
    /**
     * Retrieves the ID of the object.
     *
     * @return  the ID of the object
     */
    public long getId() {
        return id;
    }
        /**
     * Sets the ID of the object.
     *
     * @param  id  the new ID value
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
     * @param  firstName  the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Retrieves the last name of the object.
     *
     * @return          The last name of the object.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Sets the last name of the object.
     *
     * @param  lastName  the last name to be set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Retrieves the gender of the object.
     *
     * @return the gender of the object
     */
    public String getGender() {
        return gender;
    }
    /**
     * Sets the gender of the object.
     *
     * @param  gender  the gender to be set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    /**
     * Retrieves the email associated with this object.
     *
     * @return         	the email associated with this object
     */
    public String getEmail() {
        return email;
    }
    /**
     * Set the email address.
     *
     * @param  email  the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }



}
package org.question1;
//Understanding problem statement:
//things to take care of:(but in this we just have to implement the User)
//1)User Registration
//2)Patient Treatment
//3)Room Allotted
//4)in-patients

//From User class we have to inherit: (we have to do this part in this question)
//1)User: id (long), firstName (String), lastName (String), gender (String), email (String)
//1.1)Patient: patientId (long), insured (boolean)
//1.2)Staff: staffId (long), yearsOfExperience (int), description (String), salary (double)
//1.3)Doctor: doctorId (long), specialization (String)
//1.4)Nurse: nurseId (long)

public class User {
    private long id;
    // added rest of the variables
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
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
}

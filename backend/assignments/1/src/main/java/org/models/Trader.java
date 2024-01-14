package org.models;

public class Trader {
    private String id;
    private String firstName;
    private String lastName;
    String phone;
    private String walletAddress;
   // private Portfolio portfolio;

    public Trader(String id, String firstName,String lastName,String phone,String walletAddress){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.walletAddress=walletAddress;
        this.phone=phone;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

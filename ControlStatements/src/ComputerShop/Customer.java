package ComputerShop;

import AddressBook.*;

/**
 * Created by student on 26/08/2016.
 */
public class Customer extends Address{


    private String phoneNumber;
    private String email;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    Customer(){}

    public Customer(String firstName, String lastName, int houseNumber, String streetName, String city, String county, String postCode, String phoneNumber, String email){

        super(firstName,lastName,houseNumber,streetName,city,county,postCode);

        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString(){

        return  String.format(" %s %s %s %s %s %s %s %s %s", this.getFirstName(), this.getLastName(), this.getHouseNumber(), this.getStreetName(), this.getCity(), this.getCounty(), this.getPostCode(),this.phoneNumber, this.email);

    }





}

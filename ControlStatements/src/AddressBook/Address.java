package AddressBook;

/**
 * Created by student on 23/08/2016.
 */
public class Address {

    //fields
    private int houseNumber;
    private String houseName;
    private String streetName;
    private String city;
    private String town;
    private String postcode;

    //properties

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


    //constructors

    public Address(int houseNumber, String streetName, String city, String town, String postcode) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.city = city;
        this.town = town;
        this.postcode = postcode;
    }

    public Address(String houseName, String streetName, String city, String town, String postcode) {
        this.houseName = houseName;
        this.streetName = streetName;
        this.city = city;
        this.town = town;
        this.postcode = postcode;
    }

    //methods


    @Override
    public String toString(){

        return String.format("The Address: %s %s %s %s %s", this.houseNumber, this.streetName, this.city, this.town, this.postcode );

    }



}

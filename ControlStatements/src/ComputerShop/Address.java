package ComputerShop;

/**
 * Created by student on 26/08/2016.
 */
public class Address extends Person{

    private int houseNumber;
    private String streetName;
    private String city;
    private String county;
    private String postCode;

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    Address(){}

    public Address(String firstName, String lastName, int houseNumber, String streetName, String city, String county, String postCode){
        super(firstName,lastName);
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.city = city;
        this.county = county;
        this.postCode = postCode;
    }

    @Override
    public String toString(){

        return  String.format(" %s %s %s %s %s",this.houseNumber, this.streetName, this.city, this.county, this.postCode);

    }
}

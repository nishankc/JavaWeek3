package AddressBook;

/**
 * Created by student on 23/08/2016.
 */
public class Contact {

    //fields
    private Person person;
    private String email;
    private String phoneNumber;
    private String mobileNumber;

    //properties

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


    //constructors

    public Contact(Person person, String email, String phoneNumber) {
        this.person = person;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Contact(Person person, String email, String phoneNumber, String mobileNumber) {
        this.person = person;
        this.email = email;
        this.phoneNumber = phoneNumber;

        this.mobileNumber = mobileNumber;
    }

    //methods

    @Override
    public  String toString(){
        return String.format("Contact: %s %s %s", this.person.toString(), this.email, this.phoneNumber);
    }
}

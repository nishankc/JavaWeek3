package AddressBook;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by student on 23/08/2016.
 */
public class Person {

    //fields

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Address address;


    //properties

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //constructors

    public Person(String firstName, String lastName, LocalDate birthDate, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public Person(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    //methods

    public long getAge(){

        if(birthDate == null){
            return 0;
        }
        long years = ChronoUnit.YEARS.between(birthDate,LocalDate.now());
        return years;
    }

    @Override
    public String toString(){

        return  String.format(" %s %s %s %s \nAddress %s", this.firstName, this.lastName, this.getAge(), this.birthDate, this.address.toString());

    }

}

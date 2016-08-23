package AddressBook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 23/08/2016.
 */
public class generateContact {

    public  static Address address = new Address("Bob Street", 30, "Orpington", "kent", "BR6 9HE");
    public static Person person = new Person("Nishank", "Chikhalia", LocalDate.of(1989,9,8), address);
    public static Contact contact1 = new Contact(person, "fishtankc@gmail.com", "01685645236");


    public static List<Contact> contacts = new ArrayList<>();

    static void addContact(){

        contacts.add(contact1);


    }

}

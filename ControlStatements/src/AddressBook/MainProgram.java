package AddressBook;
import static AddressBook.generateContact.contacts;

/**
 * Created by student on 23/08/2016.
 */
public class MainProgram {

    public static void main(String[] args) {

        generateContact.addContact();


        for(Contact c : contacts){
            System.out.println(c);
        }

    }

}

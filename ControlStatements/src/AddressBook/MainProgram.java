package AddressBook;
import static AddressBook.generateContact.contacts;

/**
 * Created by student on 23/08/2016.
 */
public class MainProgram {

    public static void main(String[] args) {

        generateContact.addContact();

        //CommandGUI.display();
        new WelcomeWindow();
        //new MainWindow();

    }

}

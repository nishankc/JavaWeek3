package AddressBook;

import java.time.LocalDate;
import java.util.List;

import static AddressBook.generateContact.contacts;

/**
 * Created by student on 23/08/2016.
 */
public class TaskProcessing {

    static void createContact(List<String> data){

        Contact temp = new Contact(new Person(data.get(0), data.get(1), LocalDate.of(Integer.parseInt(data.get(2)),Integer.parseInt(data.get(3)), Integer.parseInt(data.get(4))),
                new Address(Integer.parseInt(data.get(5)),data.get(6),data.get(7),data.get(8), data.get(9))), data.get(10), data.get(11));


        contacts.add(temp);



    }

    static void searchContact(String search){

        for(Contact e: contacts){
            if(e.getPerson().getFirstName() != null && e.getPerson().getFirstName().contains(search)){
                System.out.println(e);
            }
        }



    }

    static void printAll(){

        for(Contact e: contacts){
            System.out.println(e);
        }
    }


}

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

    static int searchFirstName(String firstName){



        for(Contact c: contacts){
            if(c.getPerson().getFirstName().contains(firstName)){
                return contacts.indexOf(c);
            }


        }
        return -1;
    }

    static void printAll(){

        for(Contact e: contacts){
            System.out.println(e);
        }
    }


    static void removeContact(int index){
        contacts.remove(index);
    }

    static void editDetails(int index, List<String> data){

        contacts.get(index).getPerson().setFirstName(data.get(0));
        contacts.get(index).getPerson().setLastName(data.get(1));
        contacts.get(index).getPerson().setBirthDate(LocalDate.of(Integer.parseInt(data.get(2)),Integer.parseInt(data.get(3)), Integer.parseInt(data.get(4))));
        contacts.get(index).getPerson().getAddress().setHouseNumber(Integer.parseInt(data.get(5)));
        contacts.get(index).getPerson().getAddress().setStreetName(data.get(6));
        contacts.get(index).getPerson().getAddress().setCity(data.get(7));
        contacts.get(index).getPerson().getAddress().setTown(data.get(8));
        contacts.get(index).getPerson().getAddress().setPostcode(data.get(9));
        contacts.get(index).setEmail(data.get(10));
        contacts.get(index).setPhoneNumber(data.get(11));



    }





}

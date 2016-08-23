package AddressBook;

import com.sun.javafx.tk.Toolkit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by student on 23/08/2016.
 */
public class CommandGUI {

    static Scanner input = new Scanner(System.in);

    static void display(){

        int choice;

        do{

            System.out.println("Welcome to The Contacts Database");
            System.out.println("1. Add an Contact");
            System.out.println("2. Edit an Contact");
            System.out.println("3. Remove an Contact");
            System.out.println("4. List all Contacts");
            System.out.println("5. Search by First Name");
            System.out.println("6. Exit");
            System.out.println();
            System.out.println("Enter Between (1-6)");

            //read input
            choice = input.nextInt();

        } while (choice < 1 || choice > 6);


        List<String> tempData = new ArrayList<>();

        switch (choice){
            case 1:
                tempData = inputScreen();
                TaskProcessing.createContact(tempData);
                display();
            case 2:
            case 3:
            case 4:
                TaskProcessing.printAll();
                display();
            case 5:
                TaskProcessing.searchContact("nish");
            case 6:
                break;


        }


    }

    private static List<String> inputScreen() {

        List<String> contactData = new ArrayList<>();
        input.nextLine();

        System.out.print("Enter First Name:");
        contactData.add(input.nextLine());

        System.out.print("Enter Last Name: ");
        contactData.add(input.nextLine());

        System.out.print("Enter DOB (YYYY/MM/DD");
        String dob = input.nextLine();
        String[] dobData = dob.split("/");

        for(int i = 0; i <= dobData.length-1; i++){
            contactData.add(dobData[i]);
        }

        System.out.print("Enter house Number: ");
        contactData.add(input.nextLine());

        System.out.print("Enter Street Name: ");
        contactData.add(input.nextLine());



        System.out.print("Enter City");
        contactData.add(input.nextLine());

        System.out.print("Enter Town");
        contactData.add(input.nextLine());

        System.out.print("Enter PostCode: ");
        contactData.add(input.nextLine());

        System.out.print("Enter Email: ");
        contactData.add(input.nextLine());

        System.out.print("Enter PhoneNumber: ");
        contactData.add(input.nextLine());

        return contactData;


    }




}
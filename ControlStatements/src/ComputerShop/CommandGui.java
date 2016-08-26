package ComputerShop;

import java.util.*;

import static ComputerShop.generateCustomer.customer;
import static ComputerShop.generateDesktop.desktop;
import static ComputerShop.generateLaptop.laptop;

/**
 * Created by student on 26/08/2016.
 */
public class CommandGui {

    static Scanner input = new Scanner(System.in);

    static void display(){

        char choiceMainMenu;

        do{

            System.out.println("Welcome to Computer Shop");
            System.out.println("A) Add a Computer");
            System.out.println("B) Add a Customer");
            System.out.println("C) Search");
            System.out.println("D) List Customers");
            System.out.println("E) Sort");
            System.out.println("Q) Exit");
            System.out.println();
            System.out.println("Enter (A, B, C, D, E or Q)");

            //read input
            choiceMainMenu = input.nextLine().toUpperCase().charAt(0);

        } while (choiceMainMenu == 'A' && choiceMainMenu == 'B' && choiceMainMenu == 'C' && choiceMainMenu == 'D' && choiceMainMenu == 'E' && choiceMainMenu == 'Q');

        int index;
        List<String> tempData = new ArrayList<>();

        switch (choiceMainMenu){
            case 'A':
                computerDisplay();
                break;
            case 'B':
                tempData = inputScreenCustomer();
                TaskProcessing.createCustomer(tempData);
                display();
                break;
            case 'C':
                displaySearch();
                break;
            case 'D':
                TaskProcessing.printAllCustomers();
                display();
                break;
            case 'E':
                displaySort();
                break;
            case 'Q':
                break;

        }


    }



    static void computerDisplay(){

        char choiceDisplay;

        do{

            System.out.println("Welcome to the Computers");
            System.out.println("A) Add a Desktop");
            System.out.println("B) Add a Laptop");
            System.out.println("C) List Laptops");
            System.out.println("D) List Desktops");
            System.out.println("R) Return to Main Menu");
            System.out.println();
            System.out.println("Enter A, B, C, D or R");

            //read input
            choiceDisplay = input.nextLine().toUpperCase().charAt(0);

        } while (choiceDisplay == 'A' && choiceDisplay == 'B' && choiceDisplay == 'C' && choiceDisplay == 'D' && choiceDisplay == 'R');

        int index;
        List<String> tempData = new ArrayList<>();

        switch (choiceDisplay){
            case 'A':
                tempData = inputScreenDesktop();
                TaskProcessing.createDesktop(tempData);
                computerDisplay();
                break;
            case 'B':
                tempData = inputScreenLaptop();
                TaskProcessing.createLaptop(tempData);
                computerDisplay();
                break;
            case 'C':
                TaskProcessing.printAllLaptops();
                computerDisplay();
                break;
            case 'D':
                TaskProcessing.printAllDesktops();
                computerDisplay();
                break;
            case 'R':
                display();
                break;



        }
    }

    static void displaySearch(){

        char choiceSearch;

        do{

            System.out.println("Welcome to Search");
            System.out.println("A) Search for a laptop");
            System.out.println("B) Search for a desktop");
            System.out.println("C) Search for a customer");
            System.out.println("R) Return to main menu");
            System.out.println();
            System.out.println("Enter A, B, C or R");

            //read input
            choiceSearch = input.nextLine().toUpperCase().charAt(0);

        } while (choiceSearch == 'A' && choiceSearch == 'B' && choiceSearch == 'C' && choiceSearch == 'R');

        int index;
        List<String> tempData = new ArrayList<>();

        switch (choiceSearch){
            case 'A':
                index = findModelNameLaptop();
                System.out.println(laptop.get(index));
                displaySearch();
                break;
            case 'B':
                index = findModelNameDesktop();
                System.out.println(desktop.get(index));
                displaySearch();
                break;
            case 'C':
                index = findFirstName();
                System.out.println(customer.get(index));
                displaySearch();
                break;
            case 'R':
                display();
                break;



        }


    }

    static void displaySort(){

        char choiceSort;

        do{

            System.out.println("Welcome to Sort");
            System.out.println("A) Sort by laptop price");
            System.out.println("B) Sort by desktop price");
            System.out.println("C) Sort the customers");
            System.out.println("R) Return to main menu");
            System.out.println("Enter A, B, C or R");

            //read input
            choiceSort = input.nextLine().toUpperCase().charAt(0);

        } while (choiceSort == 'A' && choiceSort == 'B' && choiceSort == 'C' && choiceSort == 'R');



        switch (choiceSort){
            case 'A':
                Collections.sort(laptop, new Comparator<Laptop>() {
                    @Override
                    public int compare(Laptop o1, Laptop o2) {
                        if(o1.getPrice() < o2.getPrice()){
                            return -1;
                        }else if(o1.getPrice() > o2.getPrice()){
                            return 1;
                        }

                        return 0;
                    }
                });
                TaskProcessing.printAllLaptops();
                displaySort();
                break;
            case 'B':
                Collections.sort(desktop, new Comparator<Desktop>() {
                    @Override
                    public int compare(Desktop o1, Desktop o2) {
                        if(o1.getPrice() < o2.getPrice()){
                            return -1;
                        }else if(o1.getPrice() > o2.getPrice()){
                            return 1;
                        }

                        return 0;
                    }
                });
                TaskProcessing.printAllDesktops();
                displaySort();
                break;

            case 'C':
                Collections.sort(customer, new Comparator<Customer>() {
                    @Override
                    public int compare(Customer o1, Customer o2) {
                        return o1.getFirstName().compareTo(o2.getFirstName());
                    }
                });
                TaskProcessing.printAllCustomers();
                displaySort();
                break;
            case 'R':
                display();
                break;



        }


    }

    private static List<String> inputScreenCustomer() {

        List<String> customerData = new ArrayList<>();
        input.nextLine();

        System.out.print("Enter First Name:");
        customerData.add(input.nextLine());

        System.out.print("Enter Last Name: ");
        customerData.add(input.nextLine());

        System.out.print("Enter house number: ");
        customerData.add(input.nextLine());

        System.out.print("Enter street name: ");
        customerData.add(input.nextLine());

        System.out.print("Enter City");
        customerData.add(input.nextLine());

        System.out.print("Enter County");
        customerData.add(input.nextLine());

        System.out.print("Enter Postcode: ");
        customerData.add(input.nextLine());

        System.out.print("Enter Phone Number");
        customerData.add(input.nextLine());

        System.out.print("Enter Email Address");
        customerData.add(input.nextLine());


        return customerData;


    }

    private static List<String> inputScreenDesktop() {

        List<String> desktopData = new ArrayList<>();
        input.nextLine();

        System.out.print("Enter Model Name:");
        desktopData.add(input.nextLine());

        System.out.print("Enter CPU Type: ");
        desktopData.add(input.nextLine());

        System.out.print("Enter CPU Speed: ");
        desktopData.add(input.nextLine());

        System.out.print("Enter Hard Disk Size: ");
        desktopData.add(input.nextLine());

        System.out.print("Enter Graphics Card: ");
        desktopData.add(input.nextLine());

        System.out.print("Enter Operating System: ");
        desktopData.add(input.nextLine());

        System.out.print("Enter Price: ");
        desktopData.add(input.nextLine());

        System.out.print("Enter Montior Model: ");
        desktopData.add(input.nextLine());

        System.out.print("Enter Keyboard Model: ");
        desktopData.add(input.nextLine());

        System.out.print("Enter Speaker Model: ");
        desktopData.add(input.nextLine());


        return desktopData;


    }

    private static List<String> inputScreenLaptop() {

        List<String> desktopData = new ArrayList<>();
        input.nextLine();

        System.out.print("Enter Model Name:");
        desktopData.add(input.nextLine());

        System.out.print("Enter CPU Type: ");
        desktopData.add(input.nextLine());

        System.out.print("Enter CPU Speed: ");
        desktopData.add(input.nextLine());

        System.out.print("Enter Hard Disk Size: ");
        desktopData.add(input.nextLine());

        System.out.print("Enter Graphics Card: ");
        desktopData.add(input.nextLine());

        System.out.print("Enter Operating System: ");
        desktopData.add(input.nextLine());

        System.out.print("Enter Price: ");
        desktopData.add(input.nextLine());

        System.out.print("Enter Battery Type: ");
        desktopData.add(input.nextLine());


        System.out.print("Enter Weight: ");
        desktopData.add(input.nextLine());


        return desktopData;


    }

    static int findFirstName(){
        System.out.print("Enter Customer First Name");
        String firstName = input.next();
        return TaskProcessing.searchFirstName(firstName);
    }

    static int findModelNameLaptop(){
        System.out.print("Enter Model Name");
        String modelName = input.next();
        return TaskProcessing.searchModelNameLaptop(modelName);
    }

    static int findModelNameDesktop(){
        System.out.print("Enter Model Name");
        String modelName = input.next();
        return TaskProcessing.searchModelNameDesktop(modelName);
    }





}

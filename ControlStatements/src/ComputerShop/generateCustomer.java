package ComputerShop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 26/08/2016.
 */
public class generateCustomer {

    public static Customer test = new Customer("Bob", "Patel", 280, "Street Name", "City", "County", "Postcode", "Phone number", "Email" );
    public static Customer test1 = new Customer("D", "Patel", 280, "Street Name", "City", "County", "Postcode", "Phone number", "Email" );
    public static Customer test2 = new Customer("O", "Patel", 280, "Street Name", "City", "County", "Postcode", "Phone number", "Email" );
    public static Customer test3 = new Customer("P", "Patel", 280, "Street Name", "City", "County", "Postcode", "Phone number", "Email" );
    public static Customer test4 = new Customer("L", "Patel", 280, "Street Name", "City", "County", "Postcode", "Phone number", "Email" );
    public static Customer test5 = new Customer("M", "Patel", 280, "Street Name", "City", "County", "Postcode", "Phone number", "Email" );

    public static List<Customer> customer = new ArrayList<>();

    static void addCustomer(){

        customer.add(test);
        customer.add(test1);
        customer.add(test2);
        customer.add(test3);
        customer.add(test4);
        customer.add(test5);
    }
}

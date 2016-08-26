package ComputerShop;


import java.util.List;

import static ComputerShop.generateCustomer.customer;
import static ComputerShop.generateDesktop.desktop;
import static ComputerShop.generateLaptop.laptop;

/**
 * Created by student on 26/08/2016.
 */
public class TaskProcessing {

    static void createCustomer(List<String> data){

        Customer tempData = new Customer(data.get(0), data.get(1), Integer.parseInt(data.get(2)), data.get(3), data.get(4), data.get(5), data.get(6), data.get(7), data.get(8));

        customer.add(tempData);
    }

    static void createDesktop(List<String> data){

        Desktop tempData = new Desktop(data.get(0), data.get(1), Double.parseDouble(data.get(2)), Integer.parseInt(data.get(3)), data.get(4), data.get(5), Double.parseDouble(data.get(6)), data.get(7), data.get(8), data.get(9));

        desktop.add(tempData);
    }

    static void createLaptop(List<String> data){

        Laptop tempData = new Laptop(data.get(0), data.get(1), Double.parseDouble(data.get(2)), Integer.parseInt(data.get(3)), data.get(4), data.get(5), Double.parseDouble(data.get(6)), data.get(7), Double.parseDouble(data.get(8)));

        laptop.add(tempData);
    }

    static void printAllCustomers(){

        for(Customer c: customer){
            System.out.println(String.format("%s " + c, customer.indexOf(c)));
        }
    }

    static void printAllDesktops(){

        for(Desktop d: desktop){
            System.out.println(String.format("%s " + d, desktop.indexOf(d)));
        }
    }

    static void printAllLaptops(){

        for(Laptop l: laptop){
            System.out.println(String.format("%s " + l, laptop.indexOf(l)));
        }
    }

    static int searchFirstName(String firstName){

        for(Customer c: customer){
            if(c.getFirstName().contains(firstName)){
                return customer.indexOf(c);
            }


        }
        return -1;
    }

    static int searchModelNameLaptop(String modelName){

        for(Laptop l: laptop){
            if(l.getModel().contains(modelName)){
                return laptop.indexOf(l);
            }


        }
        return -1;
    }

    static int searchModelNameDesktop(String modelName){

        for(Desktop d: desktop){
            if(d.getModel().contains(modelName)){
                return desktop.indexOf(d);
            }


        }
        return -1;
    }
}

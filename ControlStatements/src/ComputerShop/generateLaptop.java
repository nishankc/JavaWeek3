package ComputerShop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 26/08/2016.
 */
public class generateLaptop {

    public static Laptop test = new Laptop("Model", "CPU Type", 99.99, 120, "Graphics Card", "Operating System", 99.99, "Battery Type", 10);
    public static Laptop test1 = new Laptop("Model", "CPU Type", 99.99, 120, "Graphics Card", "Operating System", 150, "Battery Type", 10);
    public static Laptop test2 = new Laptop("Model", "CPU Type", 99.99, 120, "Graphics Card", "Operating System", 50.99, "Battery Type", 10);
    public static Laptop test3 = new Laptop("Model", "CPU Type", 99.99, 120, "Graphics Card", "Operating System", 160, "Battery Type", 10);
    public static Laptop test4 = new Laptop("Model", "CPU Type", 99.99, 120, "Graphics Card", "Operating System", 200.99, "Battery Type", 10);

    public static List<Laptop> laptop = new ArrayList<>();

    public static void addLaptop(){


        laptop.add(test);
        laptop.add(test1);
        laptop.add(test2);
        laptop.add(test3);
        laptop.add(test4);

    }
}

package ComputerShop;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 26/08/2016.
 */
public class generateDesktop {

    public static Desktop test = new Desktop("Model", "CPU Type", 99.99, 120, "Graphics Card", "Operating System", 99.99, "Monitor", "Keyboard", "Speakers");
    public static Desktop test1 = new Desktop("Model", "CPU Type", 99.99, 120, "Graphics Card", "Operating System", 150, "Monitor", "Keyboard", "Speakers");
    public static Desktop test2 = new Desktop("Model", "CPU Type", 99.99, 120, "Graphics Card", "Operating System", 180.99, "Monitor", "Keyboard", "Speakers");
    public static Desktop test3 = new Desktop("Model", "CPU Type", 99.99, 120, "Graphics Card", "Operating System", 200, "Monitor", "Keyboard", "Speakers");
    public static Desktop test4 = new Desktop("Model", "CPU Type", 99.99, 120, "Graphics Card", "Operating System", 120, "Monitor", "Keyboard", "Speakers");
    public static Desktop test5 = new Desktop("Model", "CPU Type", 99.99, 120, "Graphics Card", "Operating System", 160.99, "Monitor", "Keyboard", "Speakers");

    public static List<Desktop> desktop = new ArrayList<>();

    public static void addDesktop(){


        desktop.add(test);
        desktop.add(test1);
        desktop.add(test2);
        desktop.add(test3);
        desktop.add(test4);
        desktop.add(test5);


    }
}

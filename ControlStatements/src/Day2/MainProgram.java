package Day2;
import javax.swing.*;

import static Day2.generatePeople.employees;



/**
 * Created by student on 23/08/2016.
 */
public class MainProgram {

    public static void main(String[] args) throws Exception {

        //add people
        //generatePeople.addEmployee();
        //start the welcome window
        //get from database
        TaskProcessing.prepareDB();
        new WelcomeWindow();





    }



}

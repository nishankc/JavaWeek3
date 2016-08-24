package Day2;

import AddressBook.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 23/08/2016.
 */
public class generatePeople {

    //public static Person bob = new Person("Bob", "Patel", (short) 160, 52.5, LocalDate.of(1989,4,8), SexType.MALE);

    //public static Person ted = new Person("Ted", "Patel", (short) 180, 60.5, LocalDate.of(1989, 9 , 8), SexType.MALE);

    public static Employee bobfrog = new Employee("Bob", "Frog", (short) 180, 60.5,LocalDate.of(1989,9,8),SexType.MALE, "Frog Specialist", LocalDate.of(2016, 8, 1));

    //public static List<Person> people = new ArrayList<>();

    public static List<Employee> employees = new ArrayList<>();



    static void addPeople(){

        employees.add(bobfrog);


    }

    static void addEmployee(){

        employees.add(bobfrog);


    }



}

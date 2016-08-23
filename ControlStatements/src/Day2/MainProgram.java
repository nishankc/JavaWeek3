package Day2;
import static Day2.generatePeople.employees;
import static Day2.generatePeople.people;


/**
 * Created by student on 23/08/2016.
 */
public class MainProgram {

    public static void main(String[] args){

        generatePeople.addPeople();


        for(Person p : people){
            System.out.println(p);
        }


        generatePeople.addEmployee();

        for(Employee e: employees){
            System.out.print(e);
        }


    }

}
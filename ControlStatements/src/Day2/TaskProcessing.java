package Day2;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import static Day2.generatePeople.employees;

/**
 * Created by student on 23/08/2016.
 */
public class TaskProcessing {

    static void createEmployee(List<String> data){

        BloodType blood;

        Employee temp = new Employee(data.get(0),
                data.get(1),
                Short.parseShort(data.get(2)),
                Double.parseDouble(data.get(3)),
                LocalDate.of(Integer.parseInt(data.get(4)),Integer.parseInt(data.get(5)), Integer.parseInt(data.get(6))),
                checkSex(data.get(7)),
                data.get(8),
                LocalDate.of(Integer.parseInt(data.get(9)),Integer.parseInt(data.get(10)), Integer.parseInt(data.get(11))));


        employees.add(temp);



    }

    static void printAll(){

        for(Employee e: employees){
            System.out.println(String.format("%s " + e, employees.indexOf(e)));
        }
    }

    static int searchFirstName(String firstName){

        for(Employee p: employees){
            if(p.getFirstName().contains(firstName)){
                return employees.indexOf(p);
            }


        }
        return -1;
    }

    static void editDetails(int index, List<String> data){

        employees.get(index).setFirstName(data.get(0));
        employees.get(index).setLastName(data.get(1));
        employees.get(index).setHeight(Short.parseShort(data.get(2)));
        employees.get(index).setWeight(Double.parseDouble(data.get(3)));
        employees.get(index).setBirthdate(LocalDate.of(Integer.parseInt(data.get(4)),Integer.parseInt(data.get(5)), Integer.parseInt(data.get(6))));
        employees.get(index).setSex(checkSex(data.get(7)));
        employees.get(index).setPosition(data.get(8));
        employees.get(index).setHireDate(LocalDate.of(Integer.parseInt(data.get(9)),Integer.parseInt(data.get(10)), Integer.parseInt(data.get(11))));



    }

    static SexType checkSex(String data){

        if(data.contains("M")){

            return SexType.MALE;
        }else{
            return SexType.FEMALE;
        }



    }

    static void removeEmployee(int index){
        employees.remove(index);
    }

}

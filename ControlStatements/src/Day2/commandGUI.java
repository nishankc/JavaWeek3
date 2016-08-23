package Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by student on 23/08/2016.
 */
public class commandGUI {

    static Scanner input = new Scanner(System.in);

    static void display(){

        int choice;

        do{

            System.out.println("Welcome to Employee Database");
            System.out.println("1. Add an Employee");
            System.out.println("2. Edit an Employee");
            System.out.println("3. Remove an Employee");
            System.out.println("4. List all Employee");
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

            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                break;


        }


    }

    private static List<String> inputScreen() {

        List<String> employeeData = new ArrayList<>();
        input.nextLine();

        System.out.print("Enter First Name:");
        employeeData.add(input.nextLine());

        System.out.print("Enter Last Name: ");
        employeeData.add(input.nextLine());

        System.out.print("Enter height: ");
        employeeData.add(input.nextLine());

        System.out.print("Enter weight: ");
        employeeData.add(input.nextLine());

        System.out.print("Enter DOB (YYYY/MM/DD");
        String dob = input.nextLine();
        String[] dobData = dob.split("/");

        for(int i = 0; i <= dobData.length-1; i++){
            employeeData.add(dobData[i]);
        }

        System.out.print("Enter Sex M/F");
        employeeData.add(input.nextLine());

        System.out.print("Enter Blood Type (A/B/AB/O/RHESUS_NEG");
        employeeData.add(input.nextLine());

        System.out.print("Enter Position: ");
        employeeData.add(input.nextLine());

        System.out.print("Enter Hire Date (YYYY/MM/DD");
        String hireDate = input.nextLine();
        String[] hdData = hireDate.split("/");

        for(int i = 0; i <= dobData.length-1; i++){
            employeeData.add(hdData[i]);
        }

        return employeeData;


    }


}



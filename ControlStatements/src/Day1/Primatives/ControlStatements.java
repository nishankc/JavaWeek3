package Day1.Primatives;

import java.util.Scanner;

/**
 * Created by student on 22/08/2016.
 */
public class ControlStatements {

    public static void main(String[] args){

        //int numberInput = input.nextInt();
        //input.close();

        //System.out.println(DisplayNumber(numberInput));

        //System.out.print("Please Enter a Character: ");
        //Scanner input = new Scanner(System.in);
        //char inputChar = input.next().charAt(0);

        //System.out.println(IsUpperOrLower(inputChar));

        //System.out.println("What size of ice-cream cone they like?\n" +"(1)Small - 1.25\n(2)Medium - 2.25\n(3)Large3.25\n(4)Huge 4.00");
        //Scanner input = new Scanner(System.in);
        //int inputChoice = input.nextInt();
        //System.out.println(WhatIceCream(inputChoice));

        Scanner input = new Scanner(System.in);

        System.out.println("Please Enter your First Number");
        int firstNumber = input.nextInt();
        System.out.println("Please Enter your Second Number");
        int secondNumber = input.nextInt();
        System.out.println("Please Enter your Operator");
        char operator = input.next().charAt(0);

        System.out.println("Your answer is: " + SimpleCalculator(firstNumber,secondNumber,operator));


    }

    static String DisplayNumber(int numberInput){

        String outputNumber = "";


        if(numberInput< 100){

            outputNumber = "Your Number is 100";
        }else if(numberInput < 500){

            outputNumber = "Your Number is 500";
        }else if(numberInput < 1000){
            outputNumber = "Your Number is 1000";
        }else {
            outputNumber = "Your Number is not in Scope";
        }

        return outputNumber;

    }

    static String IsUpperOrLower(char inputChar){

        String outputChar = "";


        if(Character.isUpperCase(inputChar)){

            outputChar = "Your Character is Upper Case";

        } else if(Character.isLowerCase(inputChar)){

            outputChar = "Your Character is Lower Case";
        } else {
            outputChar = "Your character is a number or a Symbol";
        }

        return outputChar;


    }


    static String WhatIceCream(int choice){

        String outputIceCream = "";

        switch (choice){
            case 1:
                outputIceCream = "(1)Small - £1.25";
                return outputIceCream;
            case 2:
                outputIceCream = "(2)Medium - £2.25";
                return  outputIceCream;
            case 3:
                outputIceCream = "(3)Large - £3.25";
                return  outputIceCream;
            case 4:
                outputIceCream = "(4)Huge -  £4.00";
                return  outputIceCream;
            default:
                outputIceCream = "Incorrect Input";
                return  outputIceCream;

        }

    }

    static int SimpleCalculator(int firstNumber, int secondNumber, char operator){

        int total = 0;

        switch (operator){
            case '+':
                total = firstNumber + secondNumber;
                break;
            case '-':
                total = firstNumber + secondNumber;
                break;
            case '*':
                total = firstNumber * secondNumber;
                break;
            case '/':
                total = firstNumber/secondNumber;
                break;
            default:
                System.out.println("Incorrect Input");
                break;
        }

        return total;
    }
}

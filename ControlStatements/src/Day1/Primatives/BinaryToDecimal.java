package Day1.Primatives;

import java.util.Scanner;

/**
 * Created by student on 22/08/2016.
 */
public class BinaryToDecimal {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter in a Binary Number: ");
        int number = input.nextInt();
        System.out.println("Your orignal binary number was " + number + " and the decimal number is " + BinaryToDecimal(number));


    }


    public static int BinaryToDecimal(int binaryNumber){

        int decimal = 0;
        int power = 0;


        while(true){
            if(binaryNumber == 0){
                break;
            } else{

                int endDigit = binaryNumber % 10;

                decimal += endDigit * Math.pow(2,power);
                power++;
                binaryNumber = binaryNumber/10;

            }




        }

        return decimal;

    }


}

package Day1.Primatives;

import java.util.Scanner;

/**
 * Created by student on 22/08/2016.
 */
public class Light {

    static int lightSpeed = 186000;

    public static void main(String[] args){
        //calculate speed of light


        //System.out.print("Enter the number of days: ");
        //Scanner input = new Scanner(System.in);
       // long days = input.nextLong();

        //System.out.println(lightCalculator(days));
        //Scanner input = new Scanner(System.in);
        //System.out.println("Please Enter a number between 0-2000");





    }

    static long lightCalculator(long days){


        long seconds = days * 24 * 60 * 60;

        return lightSpeed * seconds;

    }


}

package Day1.Primatives;

import java.util.*;

/**
 * Created by student on 22/08/2016.
 */
public class LotteryGame {

    public static void main(String[] args){

        System.out.println(DisplayLotteryNumbers(RandomLotteryNumbers()));




    }


    public static int[] RandomLotteryNumbers(){

        int[] lotteryNumbers = new int[5];

        for(int i = 0; i < lotteryNumbers.length; i++){

            lotteryNumbers[i] = GenerateNumbers(lotteryNumbers);

        }

        return lotteryNumbers;
    }


    public static int GenerateNumbers(int[] lotteryNumbers){

        Random randomNumber = new Random();
        int random = Math.abs(randomNumber.nextInt(9)+1);

        for(int i = 0; i < lotteryNumbers.length; i++){

            if(lotteryNumbers[i] == random){
                return GenerateNumbers(lotteryNumbers);
            }

        }
        return random;
    }


    public static String DisplayLotteryNumbers(int[] numbers){

        String display = "";

        Arrays.sort(numbers);

        for(int s : numbers){

            display += String.format(s + " ");

        }

        return display;

    }

    public static String GetUserLotteryNumbers(){

        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your 5 numbers(followed by a space between each number");
        String userNumbers = input.nextLine();

        return userNumbers;

    }

    public static int[] UserLotteryArray(String userLotteryNumbers){

        int[] userNumbers = new int[5];
        String[] stringUserNumbers = userLotteryNumbers.split(" ");

        for(int i = 0; i < stringUserNumbers.length; i++){
            String convert = stringUserNumbers[i];

            userNumbers = Integer.parseInt(stringUserNumbers);
        }


    }



}

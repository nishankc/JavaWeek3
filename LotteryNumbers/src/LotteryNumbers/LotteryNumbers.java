package LotteryNumbers;
import com.sun.deploy.util.ArrayUtil;

import java.util.*;

/**
 * Created by Nishank on 22/08/2016.
 */


public class LotteryNumbers {

    public static int[] AddLotteryNumbers(){

        int[] lotteryNumbers = new int[5];

        for(int i = 0; i < lotteryNumbers.length; i++){

            lotteryNumbers[i] = generateLotteryNumbers(lotteryNumbers);

        }

        System.out.println("The Lottery Numbers Are: \n");
        DisplayNumbers(lotteryNumbers);


        return lotteryNumbers;
    }

    public static int generateLotteryNumbers(int[] numbers)
    {
        Random number = new Random();
        int random = (number.nextInt(9)+1);

        for(int i = 0; i <numbers.length ; i++)
        {
            if(numbers[i] == random)
            {
                return generateLotteryNumbers(numbers);
            }
        }


        return random;
    }

    public static void DisplayNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            Arrays.sort(numbers);
            System.out.print(numbers[i]);
        }
        System.out.println("\n");
    }

    public static String getUserInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your 5 Numbers, followed by a space after each number: ");
        String userNumbers = input.nextLine();
        return userNumbers;
    }

    public static int[] userNumbers(String userNumbers){

        int[] numbers = new int[5];
        String[] stringArray = userNumbers.split(" ");

        for (int i = 0; i < stringArray.length; i++) {
            String numberAsString = stringArray[i];
            numbers[i] = Integer.parseInt(numberAsString);
        }

        Arrays.sort(numbers);
        DisplayNumbers(numbers);

        return numbers;
    }




    static void CheckNumbers(int lotteryNumbers[],int userNumbers[])
    {

        int[] combine = new int[lotteryNumbers.length + userNumbers.length];
        System.arraycopy(lotteryNumbers, 0, combine, 0, lotteryNumbers.length);
        System.arraycopy(userNumbers, 0, combine, lotteryNumbers.length, userNumbers.length);

        DisplayNumbers(combine);



        for(int x = 1; x < combine.length; x++){

            if(combine[x] == combine[x-1]){
                System.out.println("The Matching Numbers are: " + combine[x]);
            }
        }



    }



    public static void main(String[] args) {





        CheckNumbers(userNumbers(getUserInput()), AddLotteryNumbers());

    }

}


package Day1.Primatives;

/**
 * Created by student on 22/08/2016.
 */
public class ArraysInClass {

    public static void main(String[] args){

        int[] numbers = {1, 2, 2};
        int[] numbers1 = {1, 2, 1, 2};
        int[] numbers2 = {2, 1, 2};

        int[] numbers3 = {7, 3};
        int[] numbers4 = {7, 3, 2};
        int[] numbers5 = {1, 3};



        //System.out.println(has22(numbers));
        //System.out.println(has22(numbers1));
        //System.out.println(has22(numbers2));

        System.out.println(DisplayArray(MaxEnd3(numbers)));




    }


    public static String DisplayArray(int[] numbers){

        String display = "";

        for(int s : numbers){

            display += String.format(s + " ");

        }

        return display;

    }



    public static boolean FirstLast6(int[] numbers){

        if(numbers[0] == 6 || numbers[numbers.length-1] == 6){
            return true;
        } else {
            return false;
        }

    }

    public  static boolean SameFirstLast(int[] numbers){

        if(numbers.length >= 1 && numbers[0] == numbers[numbers.length-1]){

            return true;
        }else {
            return false;
        }
    }

    public static boolean CommonEnd(int[] numbers, int[] numbers2){

        if(numbers[0] == numbers2[0] || numbers[numbers.length-1] == numbers2[numbers2.length-1]){
            return true;
        }else {
            return false;
        }
    }

    public static int[] MaxEnd3(int[] numbers){



        if(numbers[0] > numbers[2]){

            int[] tempArray = {numbers[0],numbers[0], numbers[0]};
            return tempArray;
        }else {
            int[] tempArray = {numbers[2], numbers[2], numbers[2]};
            return  tempArray;
        }
    }

    public static  boolean Has23(int[] numbers){

        if(numbers[0] == 2 || numbers[1] == 2 || numbers[0] == 3 || numbers[1] == 3){
            return true;
        } else {
            return false;

        }

    }

    public static int SameFirstLast2(int[] numbers){

        int countEvens = 0;

        for(int i = 0; i < numbers.length; i++){

            if(numbers[i] %2 == 0){
                countEvens++;
            }

        }

        return countEvens;
    }

    public static int BigDiff(int[] numbers){

        int max = numbers[0];
        int min = numbers[0];

        for(int i = 0; i < numbers.length; i++){

            if(numbers[i] > max){
                max = numbers[i];
            }

            if(numbers[i] <= min){
                min = numbers[i];
            }

        }

        return max-min;
    }

    public static int sum13(int [] numbers){

        int sum = 0;

        for(int i = 0; i < numbers.length; i++){

            if(numbers[i] != 13){
                sum += numbers[i];
            }else if(i <= numbers.length-1){
                i++;
            }

        }

        return sum;
    }

    public static int sum67(int[] numbers){

        int sum = 0;

        for(int i = 0; i < numbers.length; i++){

            if(numbers[i] != 6){

                sum += numbers[i];
            } else {

                while(numbers[i] != 7){
                    i++;
                }
            }

        }

        return sum;
    }

    public static boolean has22(int[] numbers){

        boolean found = false;

        for(int i = 0; i < numbers.length - 1; i++){

            if(numbers[i] == 2 && numbers[i+1] == 2) {
                found = true;
            }else {
                found = false;
            }
        }
        return found;
    }
}




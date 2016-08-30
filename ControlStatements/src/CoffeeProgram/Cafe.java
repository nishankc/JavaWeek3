package CoffeeProgram;

/**
 * Created by student on 26/08/2016.
 */
public class Cafe {


    private int beansInStock = 0;
    private int milkInStock = 0;

    //method otherloading
    public Coffee brew(CoffeeType coffeeType){
        return brew(coffeeType,1);
    }

    public Coffee brew(CoffeeType coffeeType, int quantity){
        requiredPositive(quantity);
        int requiredBeans = coffeeType.getRequiredBeans() * quantity;
        int requiredMilk = coffeeType.getRequiredMilk() * quantity;

        if(requiredBeans > beansInStock || requiredMilk > milkInStock){

            throw new IllegalStateException("Insufficient Beans or milk");
        }
        beansInStock -= requiredBeans;
        milkInStock -= requiredMilk;

        return new Coffee(coffeeType, requiredBeans, requiredMilk);


    }


    public void requiredPositive(int value){
        if(value < 1)
            throw new IllegalArgumentException();

    }

    public void addBeans(int weightInGrams){

        requiredPositive(weightInGrams);
        beansInStock += weightInGrams;

    }

    public void addMilk(int weightInGrams){

        requiredPositive(weightInGrams);
        milkInStock += weightInGrams;

    }


}

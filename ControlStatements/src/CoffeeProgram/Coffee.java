package CoffeeProgram;

/**
 * Created by student on 26/08/2016.
 */
public class Coffee {

    private final CoffeeType type;
    private final int beans, milk;

    public Coffee(CoffeeType type, int beans, int milk) {
        this.type = type;
        this.beans = beans;
        this.milk = milk;
    }

    public CoffeeType getType() {
        return type;
    }

    public int getBeans() {
        return beans;
    }

    public int getMilk() {
        return milk;
    }
}

package CoffeeProgram;

/**
 * Created by student on 26/08/2016.
 */

import org.junit.*;
import org.hamcrest.*;

public class CafeTest {

    public static final int NO_MILK = 0;
    public static final int NO_BEANS = 0;
    public static final int ESPRESSO_BEANS = CoffeeType.Espresso.getRequiredBeans();

    private Cafe cafe;

    @Before
    public void before(){
        cafe = new Cafe();
    }

    @Test
    public void canBrewEspresso(){
        //Given
        withBeans();

        //When
        Coffee coffee = cafe.brew(CoffeeType.Espresso);
        //Then
        //1 - is it an espresso
        Assert.assertEquals("Wrong Coffee Type", CoffeeType.Espresso, coffee.getType());
    }

    public void withBeans(){
        cafe.addBeans(ESPRESSO_BEANS);

    }
}

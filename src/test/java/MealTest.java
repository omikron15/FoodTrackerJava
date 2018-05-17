import db.DBHelper;
import db.DBMeal;
import models.foods.*;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static junit.framework.Assert.assertEquals;

public class MealTest {

    Meal meal1;
    Meat meat1;
    Meat meat2;
    Grain grain1;
    Grain grain2;
    Fruit fruit1;
    Fruit fruit2;

    @Before
    public void setUp() throws Exception {
         meat1 = new Meat("Beef", 2000, "cow");

        fruit1 = new Fruit("apple", 100, "Golden Delicious");

         grain1 =  new Grain("pasta", 1500, "wheat");

         meal1 = new Meal("Meal 1", MealType.BREAKFAST, new GregorianCalendar(2018, 0, 1));
        meal1.addFood(fruit1);
        meal1.addFood(meat1);
        meal1.addFood(grain1);
        DBHelper.save(meat1);
        DBHelper.save(fruit1);
        DBHelper.save(grain1);
        DBHelper.save(meal1);
    }

    @Test
    public void TestgetCalCount() {
        assertEquals(3600, meal1.calculateCalCount());
    }

//    @Test
//    public void testDayCalCount() {
//        assertEquals(3600, DBMeal.calculateDailyCals( new GregorianCalendar(2018, 0 , 1)));
//    }
}

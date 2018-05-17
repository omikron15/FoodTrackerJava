import db.DBHelper;
import models.foods.*;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Meat meat1 = new Meat("Beef", 2000, "cow");
        Meat meat2 = new Meat("Beef 2", 2000, "cow");
        Fruit fruit1 = new Fruit("apple", 100, "Golden Delicious");
        Fruit fruit2 = new Fruit("apple 2", 100, "Golden Delicious");
        Grain grain1 =  new Grain("pasta", 1500, "wheat");
        Grain grain2 =  new Grain("pasta", 1500, "whole grain");

        DBHelper.save(fruit1);
        DBHelper.save(fruit2);
        DBHelper.save(meat1);
        DBHelper.save(meat2);
        DBHelper.save(grain1);
        DBHelper.save(grain2);

        Meal meal1 = new Meal("Meal 1", MealType.BREAKFAST);
        meal1.addFood(fruit1);
        meal1.addFood(meat1);
        meal1.addFood(grain1);

        DBHelper.save(meal1);

        List<Meal> allMeals = DBHelper.getAll(Meal.class);

    }
}

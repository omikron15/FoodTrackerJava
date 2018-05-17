import db.DBHelper;
import db.DBMeal;
import models.foods.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
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

        Meal meal1 = new Meal("Meal 1", MealType.BREAKFAST, new GregorianCalendar(2018, 0, 1));
        meal1.addFood(fruit1);
        meal1.addFood(meat1);
        meal1.addFood(grain1);

        Meal meal2 = new Meal("Meal 2", MealType.LUNCH, new GregorianCalendar(2018, 0, 1));
        meal1.addFood(fruit1);
        meal1.addFood(fruit2);

        Meal meal3 = new Meal("Meal 3", MealType.DINNER, new GregorianCalendar(2018, 0, 1));
        meal1.addFood(meat1);
        meal1.addFood(grain1);

        Meal meal4 = new Meal("Meal 4", MealType.BREAKFAST, new GregorianCalendar(2018, 0, 2));
        meal1.addFood(meat2);
        meal1.addFood(grain2);

        Meal meal5 = new Meal("Meal 5", MealType.LUNCH, new GregorianCalendar(2018, 0, 2));
        meal1.addFood(fruit1);
        meal1.addFood(grain2);

        DBHelper.save(meal1);
        DBHelper.save(meal2);
        DBHelper.save(meal3);
        DBHelper.save(meal4);
        DBHelper.save(meal5);

        List<Meal> allMeals = DBHelper.getAll(Meal.class);

        List<Meal> allBreakfast = DBMeal.findAllMealTypes(MealType.BREAKFAST);
        List<Meal> allLunch = DBMeal.findAllMealTypes(MealType.LUNCH);
        List<Meal> allDinner = DBMeal.findAllMealTypes(MealType.DINNER);

        List<Meal> allMealsOnDay = DBMeal.findAllonDay(new GregorianCalendar(2018, 0, 1));
        int totalCals = calculateDailyCals(new GregorianCalendar(2018,0,1));


    }

    public static int calculateDailyCals(GregorianCalendar date){
        int total = 0;
        List<Meal> meals = DBMeal.findAllonDay(date);
        for (Meal meal : meals){
            for (Food food : DBMeal.getFoodForMeal(meal)){
                total += food.getCalories();
            }
        }
        return total;
    }
}

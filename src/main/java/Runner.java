import db.DBHelper;
import models.foods.Fruit;
import models.foods.Grain;
import models.foods.Meat;

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

    }
}

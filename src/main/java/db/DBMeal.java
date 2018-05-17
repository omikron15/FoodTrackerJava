package db;

import models.foods.Food;
import models.foods.Meal;
import models.foods.MealType;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class DBMeal {

    private static Session session;

    public static List<Meal> findAllMealTypes( MealType type){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Meal> result = null;
        try {
            Criteria cr = session.createCriteria(Meal.class);
            cr.add(Restrictions.eq("type", type));
            result = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static List<Meal> findAllonDay(GregorianCalendar date){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Meal> result = null;
        try {
            Criteria cr = session.createCriteria(Meal.class);
            cr.add(Restrictions.eq("date", date));
            result = cr.list();

        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }



    public static List<Food> getFoodForMeal(Meal meal){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Food> foodList = null;
        try {
            Criteria cr = session.createCriteria(Food.class);
            cr.createAlias("meals", "meal");
            cr.add(Restrictions.eq("meal.id", meal.getId()));
            foodList = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return foodList;
    }
}

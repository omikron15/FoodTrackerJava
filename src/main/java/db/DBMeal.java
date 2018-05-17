package db;

import models.foods.Meal;
import models.foods.MealType;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBMeal {

    private static Session session;

    public static List<Meal> findAllMealTypes(Class classType, MealType type){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Meal> result = null;
        try {
            Criteria cr = session.createCriteria(classType);
            cr.add(Restrictions.eq("type", type));
            result = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}

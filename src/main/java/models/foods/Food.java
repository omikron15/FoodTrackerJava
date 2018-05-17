package models.foods;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "foods")
public abstract class Food {

    private int id;
    private String name;
    private int calories;
    private List<Meal> meals;

    public Food() {
    }

    public Food(String name, int calories) {
        this.name = name;
        this.calories = calories;
        this.meals = new ArrayList<Meal>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "calories")
    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "meal_food",
            inverseJoinColumns = {@JoinColumn(name = "meal_id", nullable = false, updatable = false)},
            joinColumns = {@JoinColumn(name = "food_id", nullable = false, updatable = false)})
    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}

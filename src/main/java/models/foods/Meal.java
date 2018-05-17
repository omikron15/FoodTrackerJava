package models.foods;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name = "meals")
public class Meal {

    private int id;
    private String name;
    private MealType type;
    private List<Food> foods;
    private GregorianCalendar date;

    public Meal() {
    }

    public Meal(String name, MealType type, GregorianCalendar date) {
        this.name = name;
        this.type = type;
        this.foods = new ArrayList<Food>();
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    public MealType getType() {
        return type;
    }

    public void setType(MealType type) {
        this.type = type;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "meal_food",
            joinColumns = {@JoinColumn(name = "meal_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "food_id", nullable = false, updatable = false)})
    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    @Column(name = "date")
    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public void addFood(Food food){
        this.foods.add(food);
    }
}

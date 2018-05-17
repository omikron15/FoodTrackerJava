package models.foods;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fruits")
public class Fruit extends Food{

    private String fruitType;

    public Fruit() {
    }

    public Fruit(String name, int calories, String fruitType) {
        super(name, calories);
        this.fruitType = fruitType;
    }

    @Column(name = "fruit_type")
    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }
}

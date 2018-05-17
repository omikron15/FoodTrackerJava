package models.foods;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "meats")
public class Meat extends Food {

    private String animalType;

    public Meat() {
    }

    public Meat(String name, int calories, String animalType) {
        super(name, calories);
        this.animalType = animalType;
    }

    @Column(name = "animal_type")
    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
}

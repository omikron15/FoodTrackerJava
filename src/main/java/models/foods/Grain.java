package models.foods;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "grains")
public class Grain extends Food {

    private String grainType;

    public Grain() {
    }

    public Grain(String name, int calories, String grainType) {
        super(name, calories);
        this.grainType = grainType;
    }

    @Column(name = "grain_type")
    public String getGrainType() {
        return grainType;
    }

    public void setGrainType(String grainType) {
        this.grainType = grainType;
    }
}

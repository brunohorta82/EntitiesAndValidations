package pt.brunohorta.entities;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by BrunoHorta on 12/04/15.
 */
@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull(message = "Brand must be specified")
    @NotBlank(message = "Brand must be specified")
    private String brand;

    @NotBlank(message = "Model must be specified")
    @NotNull(message = "Model must be specified")
    private String model;


    private List<String> extras;

    //JPA
    public Car() {
    }

    public Car(String brand, String model) {
        Objects.requireNonNull(brand,"Brand must be specified");
        Objects.requireNonNull(model,"Model must be specified");
        this.brand = brand;
        this.model = model;
    }

    public long getId() {
        return id;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        Objects.requireNonNull(brand,"Brand must be specified");
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        Objects.requireNonNull(model,"Model must be specified");
        this.model = model;
    }

    public List<String> getExtras() {
        if(this.extras == null)
            this.extras = new ArrayList<>();
        return Collections.unmodifiableList(extras);
    }

    public void addExtra(String extra) {
        Objects.requireNonNull(extra,"Extra must be specified");
        if(this.extras == null)
            this.extras = new ArrayList<>();
        this.extras.add(extra);
    }

    public void removeExtra(String extra) {
        Objects.requireNonNull(extra,"Extra must be specified");
        Objects.requireNonNull(extras,"Extras List must be initialized");
        this.extras.remove(extra);
    }


}

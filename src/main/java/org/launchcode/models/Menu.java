package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by ryanstrong on 4/12/17.
 */
@Entity
public class Menu {
    @ManyToMany
    private List<Cheese> cheese;

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    @ManyToOne
    private Category category;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addItem(Cheese item) {

    }

    public Menu(List<Cheese> cheese, String name) {
        this.cheese = cheese;
        this.name = name;
    }

    public Menu() { }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}

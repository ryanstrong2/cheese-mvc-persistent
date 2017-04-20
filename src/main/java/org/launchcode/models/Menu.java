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

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    @ManyToMany
    private List<Cheese> cheeses;

//    private String description;

    public Menu() {
    }

    @ManyToOne
    private Category category;

    public Menu(String name) {
        this.name = name;

    }

    public void addItem(Cheese item) {
    cheeses.add(item);
    }

    public Menu(List<Cheese> cheeses, String name) {
        this.cheeses = cheeses;
        this.name = name;
    }//accepts value for and sets name

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }

    public void setCheese(List<Cheese> cheeses) {
        this.cheeses = cheeses;
    }

//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

    public void setCategory(Category category) {
        this.category = category;
//    }
    }


}
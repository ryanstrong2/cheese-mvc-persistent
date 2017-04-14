package org.launchcode.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ryanstrong on 4/12/17.
 */
@Entity
public class Menu {
    private  String name;
    @ManyToMany
    private List<Cheese> cheeses;

    @Id
    @GeneratedValue
    private int id;


    @ManyToOne
    private Category category;

    public Menu(String name) {
        this.name = name;

    }

    public void addItem(Cheese item) {

    }

    public Menu(List<Cheese> cheeses, String name) {
        this.cheeses = cheeses;
        this.name = name;
    }//accepts value for and sets name

    public Menu() { }

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




//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }


}

package org.ryanstrong.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Entity
public class Cheese {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    //@Size(min=1, max=60)// size does not work with java.lang.Integer here
    private Integer name;

//    @NotNull
//    @Size(min=1, message = "Description must not be empty")
//    private String description;

    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "cheeses")
    private List<Menu> menus;

    public Cheese(Integer number
//                  String description
    ) {
        this.name = number;
//        this.description = description;
    }

    public Cheese() { }

    public int getId() {
        return id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

//    public String getDescription() {
//        return description;
//    }

//    public void setDescription(String description) {
//        this.description = description;
//    }
    public Category getCategory(){return category;}

    public void setCategory(Category category) {
        this.category = category;
    }


}

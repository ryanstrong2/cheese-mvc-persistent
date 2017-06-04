package org.ryanstrong.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by RyanStrong
 */
@Entity
public class Cheese {

//    void addTime(int number){
//        number=number+time;
//    }
    @Id
    @GeneratedValue
    private int id;//used to add and remove
    private static int nextId =1;
    private int time;

    @NotNull
    //@Size(min=1, max=60)// size does not work with java.lang.Integer here
    private Integer number;

//    @NotNull
//    @Size(min=1, message = "Description must not be empty")
//    private String description;

//    @ManyToOne
//    private Category category;// not needed

    @ManyToMany(mappedBy = "cheeses")
    private List<Menu> menus;

//    public Cheese(int id
//    ) {
//        this();//calls default constructor
//        this.id = id;
////        this.description = description;
//    }

    public Cheese() {
        id = nextId;
        nextId++;
    }
//    public  Cheese(){}
    public int getId() {
        return id;
    }
    public void setId(int id)
    {
        this.id=id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

//    public String getDescription() {
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
////    }
//    public Category getCategory(){return category;}
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

//todo add and remove user
    //todo add and remove time
}

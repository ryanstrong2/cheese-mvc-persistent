package org.ryanstrong.models;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * Created by RyanStrong
 */
@Entity
public class Cheese {

    void addTime(int number){
        number=number+tim;
    }
    @Id
    @GeneratedValue
    private int id;//used to add and remove
    private static int nextId =1;
    private int tim;

    @NotNull
    //@Size(min=1, max=60)// size does not work with java.lang.Integer here
    private Integer number;

//    @NotNull
//    @javax.persistence.Id
//    @GeneratedValue
//    private int id;

    private Integer timeToPlay;

    private void addNumbers(Integer timeToPlay, Integer timeChange){
        timeToPlay = timeToPlay + timeChange;
    }
    public Integer getTimeToPlay(){
        return timeToPlay;
    }
    //@NotNull
//    @Size(min=3, max=15)
    private String name;

    //@NotNull
//    @Size(min=1, message = "Description must not be empty")
//    private String description;

//    @ManyToOne
//    private Category category;// not needed
//    private Category category;

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
//    public int getId() {
//        return id;
//    }
    public void setId(int id)
    {
        this.id=id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;}
    public Cheese(String name
//            , String description
    ) {
        this.name = name;
//        this.description = description;
    }

//    public Cheese() { }
//
//    public int getId() {
//        return id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getDescription() {
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
////    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//    public Category getCategory(){return category;}
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//todo add and remove user
    //todo add and remove time

}

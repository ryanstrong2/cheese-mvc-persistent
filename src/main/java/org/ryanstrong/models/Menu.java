package org.ryanstrong.models;

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
    private int id;//menu id

    @NotNull
    @Size(min = 1, max = 15)
    private String name;//username

    @ManyToMany
    private List<Cheese> cheeses;//list of numbers
    @ManyToOne
    private Cheese timeToPlays;

//
//    public void setTime(Integer time) {this.time=time;}
//    public Integer getTime() {return time;}
//    public void setMinute(Integer minute) {
//        this.minute = minute;
//    }

//    @ManyToMany
//    private Integer minute;//single number
//    private String description;
    private Integer timeToPlay;
//    private Integer time;//total time
    public Menu() {
    }
//    public Menu(Integer time){
//        this.time=time;
//    }
//    @ManyToOne
//    private Category category;

//    public Menu(String name) {
//        this.name = name;
//    }

    public void addItem(Cheese item) {
    cheeses.add(item);
    }

    public Menu(List<Cheese> cheeses
//            , String name
    ) {
        this.cheeses = cheeses;//gets the list of cheeses to add to menu
//        this.name = name;
    }//accepts value for and sets name
//    public Menu(Integer minute, String name){
//        this.minute = minute;
//        this.name = name;
//    }
//    public Menu(Integer timeToPlays){this.timeToPlays=timeToPlays;}
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

    public Integer getTimeToPlay(){return timeToPlay;}

    public void setTimeToPlay(Integer timeToPlay){
        this.timeToPlay = timeToPlay;
    }

//    public void setCategory(Category category) {
//        this.category = category;
//    }
//    public Integer getMinute() {
//        return minute;
//    }


}
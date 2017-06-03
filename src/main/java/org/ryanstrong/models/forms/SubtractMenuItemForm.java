package org.ryanstrong.models.forms;

import org.ryanstrong.models.Cheese;
import org.ryanstrong.models.Menu;

import javax.validation.constraints.NotNull;

/**
 * Created by ryanstrong on 4/14/17.
 */
public class SubtractMenuItemForm {
    @NotNull
    private int menuId;

//    @NotNull
    private int Id;
    private Iterable<Cheese> cheeses;
    private Menu menu;
    private Cheese cheese;

    public Integer getSub() {
        return sub;
    }

    private Integer sub;
    public SubtractMenuItemForm(){}// default constructor for model binding
    public SubtractMenuItemForm(Cheese cheese, Menu menu){
        this.cheese = cheese;
        this.menu = menu;
    }
    public int getMenuId(){return menuId;}
//    public void setMenuId(int menuId){this.menuId = menuId;}
    public int getId(){return Id;}
//    public void setCheeseId(int cheeseId){this.cheeseId = cheeseId;}
    public Iterable<Cheese> getCheeses(){return cheeses;}
    public Menu getMenu(){
        return menu;
    }
    public void setCheeses(Iterable<Cheese> cheeses) {
        this.cheeses = cheeses;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}

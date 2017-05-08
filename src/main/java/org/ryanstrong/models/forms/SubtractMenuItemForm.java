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
    private int cheeseId;

    private Iterable<Cheese> cheeses;

    private Menu menu;

    public SubtractMenuItemForm(){}// default constructor for model binding
    public SubtractMenuItemForm(Iterable<Cheese> cheeses, Menu menu){
        this.cheeses = cheeses;
        this.menu = menu;
    }
    public int getMenuId(){return menuId;}
//    public void setMenuId(int menuId){this.menuId = menuId;}
    public int getCheeseId(){return cheeseId;}
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

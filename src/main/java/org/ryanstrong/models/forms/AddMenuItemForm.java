package org.ryanstrong.models.forms;

import org.ryanstrong.models.Menu;

import javax.validation.constraints.NotNull;

/**
 * Created by ryanstrong on 4/14/17.
 */
public class AddMenuItemForm {
    @NotNull
    private int menuId;

//    @NotNull
    private int cheeseId;

    private Integer cheese;

    private Menu menu;

    public AddMenuItemForm(){}// default constructor for model binding
    public AddMenuItemForm(Integer cheese, Menu menu){
        this.cheese = cheese;
        this.menu = menu;
    }
    public int getMenuId(){return menuId;}
    public void setMenuId(int menuId){this.menuId = menuId;}
    public int getCheeseId(){return cheeseId;}
    public void setCheeseId(int cheeseId){this.cheeseId = cheeseId;}
    public Integer  getCheese(){return cheese;}
    public Menu getMenu(){
        return menu;
    }
    public void setCheese(Integer cheese) {
        this.cheese = cheese;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}

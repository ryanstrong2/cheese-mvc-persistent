package org.ryanstrong.controllers;

import org.ryanstrong.models.Cheese;
import org.ryanstrong.models.JoinColumn;
import org.ryanstrong.models.Menu;
import org.ryanstrong.models.data.CheeseDao;
import org.ryanstrong.models.data.MenuDao;
import org.ryanstrong.models.forms.AddMenuItemForm;
import org.ryanstrong.models.forms.SubtractMenuItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OneToMany;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by ryanstrong on 4/12/17.
 */
@Controller
@RequestMapping(value="menu")
public class MenuController {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private CheeseDao cheeseDao;

    @RequestMapping(value = "")
    public String index(Model model){
            //, @RequestParam int menuId){// needs call for menu id somewhere
        model.addAttribute("menus", menuDao.findAll());
        model.addAttribute("title", "Menus");
//        model.addAttribute("minute", menuDao.findOne(Id));
        return "menu/index";
    }
    @OneToMany
    @JoinColumn(name="Menu_id")
    private List<Cheese> cheeses = new ArrayList<>();

    @RequestMapping(value="add", method= RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Add Menu");
        model.addAttribute(new Menu());
        model.addAttribute("menus", menuDao.findAll());

        return "menu/add";
    }
    @RequestMapping(value = "add", method = POST)
    public String add(Model model, @ModelAttribute @Valid Menu newMenu, Errors errors
                      ) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Menu");

//            model.addAttribute("menus", menuDao.findAll());
            return "menu/add";
        }
//
        menuDao.save(newMenu);
        return "redirect:view/" + newMenu.getId();
    }
    @RequestMapping(value = "view/{menuId}", method = RequestMethod.GET)
    public String viewMenu(Model model, @PathVariable int menuId){
        Menu menu = menuDao.findOne(menuId);
        model.addAttribute("title", menu.getName());
        model.addAttribute("cheeses", menu.getCheeses());
        model.addAttribute("menu", menu.getId());
        return "menu/view";
    }
    @RequestMapping(value = "add-item/{menuId}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int menuId)
    {
        Menu menu = menuDao.findOne(menuId);
        AddMenuItemForm form = new AddMenuItemForm(
                cheeseDao.findAll(), menu);
        model.addAttribute("title", "Add item to menu: " + menu.getName());
        model.addAttribute("form", form);
        return "menu/add-item";
    }
    @RequestMapping(value = "add-item", method = RequestMethod.POST)
    public String addItem(Model model,
                          @ModelAttribute @Valid AddMenuItemForm form, Errors errors
    ){
        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "menu/add-item";
        }
            Menu theMenu = menuDao.findOne(form.getMenuId());
            Cheese theCheese = cheeseDao.findOne(form.getCheeseId());
            theMenu.addItem(theCheese);
            menuDao.save(theMenu);
            return "redirect:/menu/view/" + theMenu.getId();
        }
    @RequestMapping(value = "remove/{menuId}", method = RequestMethod.GET)
    public String reduceTime(Model model, @PathVariable int menuId, @PathVariable int cheeseId) {
        Menu menu = menuDao.findOne(menuId);
        SubtractMenuItemForm form = new SubtractMenuItemForm(
                cheeseDao.findOne(cheeseId), menu);
        model.addAttribute("title", "Reduce time for: " + menu.getName());
        model.addAttribute("form", form);
        return "menu/remove";
    }
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String reduceTime( Model model,
                             @ModelAttribute @Valid SubtractMenuItemForm form, Errors errors
    ){
        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "menu/remove";
        }
//        for (int cheeseId : cheeseIds) {
//            menuDao.delete(cheeseId);
//        } todo get cheese Integer to be result,  add result to time, save, put chees name in form
        Integer time=Integer.parseInt(String.valueOf(cheeses));
        Integer cheese=time + 9;
        Menu theMenu = menuDao.findOne(form.getMenuId());
        Cheese theCheese = cheeseDao.findOne(form.getCheeseId());
        theMenu.addItem(theCheese);
//        menuDao.save(theMenu);
        cheeseDao.save(theCheese);//todo make cheese add
//        menuDao.delete(theMenu);
        // todo convert string to integer add to initial Integer.parseInt()
        //TODO if else for multiple buttons
        return "redirect:/menu/view/" + theMenu.getId();
    }
    @RequestMapping(value = "add-int/{menuId}", method = RequestMethod.GET)
    public String addInt(Model model, @PathVariable int menuId, @PathVariable Integer cheeseName)
    {
        Menu menu = menuDao.findOne(menuId);
        CheeseDao cheeseDao = this.cheeseDao;
//   todo get Integer from databass     AddMenuItemForm form = new AddMenuItemForm(
//                cheeseDao(cheeseName), menu);
        model.addAttribute("title", "Add item to menu: " + menu.getName());
        model.addAttribute("form", form);
        return "menu/add-int";
    }
    @RequestMapping(value = "add-int", method = RequestMethod.POST)
    public String addInt(Model model,
                          @ModelAttribute @Valid AddMenuItemForm form, Errors errors
    ){
        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "menu/add-item";
        }
        Menu theMenu = menuDao.findOne(form.getMenuId());
        Cheese theCheese = cheeseDao.findOne(form.getCheeseId());
        theMenu.addItem(theCheese);
        menuDao.save(theMenu);
        return "redirect:/menu/view/" + theMenu.getId();
    }

}


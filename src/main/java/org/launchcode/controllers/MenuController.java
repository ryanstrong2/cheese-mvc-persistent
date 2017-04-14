package org.launchcode.controllers;

import org.launchcode.models.Menu;
import org.launchcode.models.data.CheeseDao;
import org.launchcode.models.data.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by ryanstrong on 4/12/17.
 */
@Controller
@RequestMapping(value="menu")
public class MenuController {

    @Autowired
    private CheeseDao cheeseDao;

    @Autowired
    private MenuDao menuDao;

    @RequestMapping(value="add", method= RequestMethod.GET)
    public String menu(Model model){
        model.addAttribute(new Menu());
        return "add";
    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String menu(@ModelAttribute @Valid Menu newMenu, Errors errors,
                       @RequestParam int menuId, Model model){
        if (errors.hasErrors()){
        model.addAttribute("Add Menu");
        return "menu/add";
    }

    menuDao.save(newMenu);
    return "redirect:view/";

    @RequestMapping(value="view/{menuId}", method = RequestMethod.GET)
    public String viewMenu(Model model){
        model.addAttribute("menu", menuDao.findOne(menuId));


//    private addItem
}}


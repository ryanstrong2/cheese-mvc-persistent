package org.ryanstrong.controllers;

import org.ryanstrong.models.Cheese;
import org.ryanstrong.models.Menu;
import org.ryanstrong.models.data.CheeseDao;
import org.ryanstrong.models.data.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@RequestMapping("cheese")
public class CheeseController {

    @Autowired
    private CheeseDao cheeseDao;
    @Autowired
    private MenuDao menuDao;

//    @Autowired
//    private CategoryDao categoryDao;
//
//    @ManyToOne
//    private Category category;
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
//        model.addAttribute("categories", categoryDao.findAll());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute  @Valid Cheese newCheese,
                                       Errors errors,
//                                       @RequestParam int categoryId,
                                       Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            return "cheese/add";
        }
//        Category cat = categoryDao.findOne(categoryId); //category object
//
//        newCheese.setCategory(cat);

        cheeseDao.save(newCheese);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds
//            , @ModelAttribute Cheese newCheese
    ) {
        final Iterable<Menu> menus=menuDao.findAll();
        for (int cheeseId: cheeseIds) {
            final Cheese cheese = cheeseDao.findOne(cheeseId);
            for (Menu menu : menus) {
                if (menu.getCheeses().contains(cheese)) {
                    menu.getCheeses().remove(cheese);
                    menuDao.save(menu);
                }
            }

            for (int someId : cheeseIds) {
                cheeseDao.delete(someId);
            }
        }
        return "redirect:";
    }

}

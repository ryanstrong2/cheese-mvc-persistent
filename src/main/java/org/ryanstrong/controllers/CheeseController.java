package org.ryanstrong.controllers;

import org.ryanstrong.models.Category;
import org.ryanstrong.models.Cheese;
import org.ryanstrong.models.data.CategoryDao;
import org.ryanstrong.models.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ManyToOne;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("cheese")
public class CheeseController {

    @Autowired
    private CheeseDao cheeseDao;

    @Autowired
    private CategoryDao categoryDao;

    @ManyToOne
    private Category category;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }
    @GetMapping("/add")
    public String cheeseForm(Model model) {
        model.addAttribute("greeting", new Cheese());
        return "cheese/index";
    }

    @PostMapping("/add")
    public String cheeseSubmit(@ModelAttribute Cheese cheese) {
        return "cheese/index";
    }
//todo fix this
//    @RequestMapping(value = "add", method = RequestMethod.GET)
//    public String displayAddCheeseForm(Model model) {
//        model.addAttribute("title", "Add Cheese");
//        model.addAttribute(new Cheese());
//        model.addAttribute("categories", categoryDao.findAll());
//        return "cheese/add";
//    }
//
//    @RequestMapping(value = "add", method = RequestMethod.POST)
//    public String processAddCheeseForm(@ModelAttribute  @Valid Cheese newCheese,
//                                       Errors errors, @RequestParam int categoryId, Model model) {
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Cheese");
//            return "cheese/add";
//        }
//        Category cat = categoryDao.findOne(categoryId); //category object
//        newCheese.setCategory(cat);
//        cheeseDao.save(newCheese);
//        return "redirect:";
//    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {
        for (int cheeseId : cheeseIds) {
            cheeseDao.delete(cheeseId);
        }
        return "redirect:";
    }

}

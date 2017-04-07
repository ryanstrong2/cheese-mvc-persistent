package org.launchcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ryanstrong on 4/6/17.
 */
@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryDao categoryDao;

    private class CategoryDao {
    }
    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("cheeses");
        return "cheese/index";

    }
}

package org.launchcode.controllers;import org.launchcode.models.Category;import org.launchcode.models.data.CategoryDao;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.validation.Errors;import org.springframework.web.bind.annotation.ModelAttribute;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.RequestParam;import javax.validation.Valid;/** * Created by ryanstrong on 4/6/17. */@Controller@RequestMapping("category")public class CategoryController {    @Autowired    private CategoryDao categoryDao;    @RequestMapping(value="")    public String index(Model model){        model.addAttribute("Categories", categoryDao.findAll());        model.addAttribute("title", "Category");        return "category/index";    }    @RequestMapping(value="add", method = RequestMethod.GET)    public String add( @ModelAttribute @Valid Category category, Error errors, Model model){        model.addAttribute("Add Category");        model.addAttribute(new Category());        return "category/add";    }    @RequestMapping(value="add", method = RequestMethod.POST)    public String add(@ModelAttribute @Valid Category category, Errors errors, Model model){        if (errors.hasErrors()) {            model.addAttribute("Add Category");            return "category/add";        }        categoryDao.save(category);        return "redirect:";            }    @RequestMapping(value = "remove", method = RequestMethod.GET)    public String displayRemoveCategoryForm(Model model) {        model.addAttribute("categories", categoryDao.findAll());        model.addAttribute("title", "Remove Category");        return "cheese/remove";    }    @RequestMapping(value = "remove", method = RequestMethod.POST)    public String processRemoveCategoryForm(@RequestParam int[] categoryIds) {        for (int categoryId : categoryIds) {            categoryDao.delete(categoryId);        }        return "redirect:";    }}
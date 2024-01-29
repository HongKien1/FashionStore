package com.main.fashionstore.Controller.admin;

import com.main.fashionstore.Entity.Category;
import com.main.fashionstore.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public String index(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/category";
    }

    @GetMapping("/addCategory")
    public String add(Model model) {
        model.addAttribute("category", new Category());
        return "admin/category-add";
    }

    @PostMapping("/addCategory")
    public String addProduct(@Validated Category category,
                             BindingResult result, Model model) {
        if (!result.hasErrors()) {
            categoryService.save(category);
            System.out.println(category.toString());
            model.addAttribute("message", "Them thanh cong");
            return "redirect:/admin/category";
        } else {
            model.addAttribute("message", "Vui long nhap du thong tin");
        }
        return "/admin/category-add";
    }

    @GetMapping("/updateCategory/{category_id}")
    public String update(Model model, @PathVariable("category_id") Integer category_id) {
        Category category = categoryService.findById(category_id);
        model.addAttribute("category", category);
//        List<Category> categories = categoryService.findAll();
//        model.addAttribute("categories", categories);
        return "admin/category-update";
    }

    @PostMapping("/updateCategory/{category_id}")
    public String update(@Validated @PathVariable("category_id") Integer category_id,
                         Category category, BindingResult result, Model model) {
//        if (!result.hasErrors()) {
            Category category1 = categoryService.findById(category_id);

            category1.setCategory_id(category.getCategory_id());
            category1.setCategory_name(category.getCategory_name());
            categoryService.save(category);
            model.addAttribute("success", "Cap nhat thanh cong");
            return "redirect:/admin/category";
//        } else {
//            model.addAttribute("message", "Vui long nhap du thong tin");
//        }
//        return "admin/category-update";
    }

    @GetMapping("/deleteCategory/{category_id}")
    public String delete(@PathVariable("category_id") Integer category_id) {
        categoryService.remove(category_id);
        return "redirect:/admin/category";
    }
}
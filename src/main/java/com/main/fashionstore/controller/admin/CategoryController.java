package com.main.fashionstore.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/category")
public class CategoryController {
    @GetMapping("")
    public String index() {
        return "admin/category";
    }

    @GetMapping("/addCategory")
    public String add() {
        return "admin/category-add";
    }

    @GetMapping("/updateCategory")
    public String update() {
        return "admin/category-update";
    }
}
package com.main.fashionstore.Controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/Product")
public class Product_AdminController {
    @GetMapping("")
    public String index() {
        return "admin/Product";
    }

    @GetMapping("/addProduct")
    public String add() {
        return "admin/product-add";
    }

    @GetMapping("/updateProduct")
    public String update() {
        return "admin/product-update";
    }
}
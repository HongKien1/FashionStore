package com.main.fashionstore.Controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/productDetail")
public class ProductDetail_AdminController {
    @GetMapping("")
    public String index() {
        return "admin/productDetail";
    }

    @GetMapping("/addProduct")
    public String add() {
        return "admin/productDetail-add";
    }

    @GetMapping("/updateProduct")
    public String update() {
        return "admin/productDetail-update";
    }
}
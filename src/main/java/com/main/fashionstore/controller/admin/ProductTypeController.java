package com.main.fashionstore.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/productType")
public class ProductTypeController {
    @GetMapping("")
    public String index() {
        return "admin/productType";
    }

    @GetMapping("/addProductType")
    public String add() {
        return "admin/productType-add";
    }

    @GetMapping("/updateProductType")
    public String update() {
        return "admin/productType-update";
    }
}
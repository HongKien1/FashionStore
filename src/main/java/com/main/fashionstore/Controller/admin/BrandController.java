package com.main.fashionstore.Controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/brand")
public class BrandController {
    @GetMapping("")
    public String index() {
        return "admin/brand";
    }

    @GetMapping("/addBrand")
    public String add() {
        return "admin/brand-add";
    }

    @GetMapping("/updateBrand")
    public String update() {
        return "admin/brand-update";
    }
}
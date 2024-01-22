package com.main.fashionstore.Controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/color")
public class ColorController {
    @GetMapping("")
    public String index() {
        return "admin/color";
    }

    @GetMapping("/addColor")
    public String add() {
        return "admin/color-add";
    }

    @GetMapping("/updateBrand")
    public String update() {
        return "admin/color-update";
    }
}
package com.main.fashionstore.Controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/size")
public class SizeController {
    @GetMapping("")
    public String index() {
        return "admin/size";
    }

    @GetMapping("/addSize")
    public String add() {
        return "admin/size-add";
    }

    @GetMapping("/updateSize")
    public String update() {
        return "admin/size-update";
    }
}
package com.main.fashionstore.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/account")
public class AccountController {
    @GetMapping("")
    public String index() {
        return "admin/account";
    }

    @GetMapping("/addAccount")
    public String add() {
        return "admin/account-add";
    }

    @GetMapping("/updateAccount")
    public String update() {
        return "admin/account-update";
    }
}
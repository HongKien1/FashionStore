package com.main.fashionstore.Controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("account")
public class AccountUserController {
    @GetMapping("")
    public String index() {
        return "user/account";
    }
}

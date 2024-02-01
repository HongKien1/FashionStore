package com.main.fashionstore.Controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("forgot")
public class ForgotPasswordController {
    @GetMapping("")
    public String loginForm() {
        return "user/forgot-password";
    }

    @GetMapping("nhapotp")

    public String nhapMa() {
        return "user/nhapotp";
    }
    @GetMapping("nhapmkhau")

    public String nhapMatkhau() {
        return "user/nhaplaimatkhau";
    }

}

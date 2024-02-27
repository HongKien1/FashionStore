package com.main.fashionstore.Controller.admin;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class MainController {
    @Autowired
    private HttpSession session;


    @GetMapping("")
    public String index() {
        //thống kê doanh thu

        return "admin/index";
    }


    @GetMapping("logout")
    public String logout() {
        // Xóa thông tin người dùng khỏi session
        session.removeAttribute("username");
        session.removeAttribute("role");

        // Chuyển hướng về trang đăng nhập
        return "redirect:/account/login";
    }
}
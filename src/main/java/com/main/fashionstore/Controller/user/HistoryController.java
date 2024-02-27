package com.main.fashionstore.Controller.user;

import com.main.fashionstore.Entity.Order;
import com.main.fashionstore.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("history")
public class HistoryController {
    @Autowired
    OrderService orderService;
    @GetMapping("")
    public String index(Model model) {
        List<Order> oders = orderService.getAllOrders();
        model.addAttribute("orders", oders);
        return "user/historyOrder";
    }
}

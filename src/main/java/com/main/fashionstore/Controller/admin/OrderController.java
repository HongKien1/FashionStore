package com.main.fashionstore.Controller.admin;

import com.main.fashionstore.Entity.Brand;
import com.main.fashionstore.Entity.Order;
import com.main.fashionstore.Entity.OrderDetails;
import com.main.fashionstore.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("order")
    public String index(Model model) {
        List<Order> oders = orderService.getAllOrders();
        model.addAttribute("orders", oders);

        return "admin/order";
    }

    @GetMapping("orderDetail/{order_id}")
    public String detail(@PathVariable("order_id") Integer order_id, Model model) {
        Order order = orderService.getOrderById(order_id);
        model.addAttribute("order", order);
        return "admin/orderDetail";
    }
}
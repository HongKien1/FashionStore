package com.main.fashionstore.Controller.user;

import com.main.fashionstore.Entity.CartDetails;
import com.main.fashionstore.Service.CartDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("orderDetail")
public class OrderDetailController {
    @Autowired
    CartDetailsService cartDetailsService;

    @GetMapping("")
    public String index(Model model) {
        List<CartDetails> cartDetails = cartDetailsService.getAllCartDetails();
        double totalPrice = 0;
        for (CartDetails cartDetail : cartDetails) {
            totalPrice += cartDetail.getTotal();
        }
        model.addAttribute("cartDetailsPayment", cartDetails);
        model.addAttribute("totalPrice", totalPrice);
        return "user/orderDetail";
    }
}
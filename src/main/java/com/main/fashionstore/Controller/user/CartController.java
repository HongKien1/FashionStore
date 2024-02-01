package com.main.fashionstore.Controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.main.fashionstore.Entity.CartDetails;
import com.main.fashionstore.Service.CartDetailsService;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    CartDetailsService cartDetailsService;

    @GetMapping("")
    public String index(Model model) {
        List<CartDetails> cartDetails = cartDetailsService.getAllCartDetails();
        model.addAttribute("cartDetails", cartDetails);
        return "user/shoping-cart";
    }

}
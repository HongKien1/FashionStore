package com.main.fashionstore.Controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.fashionstore.Entity.CartDetails;
import com.main.fashionstore.Entity.ProductDetails;
import com.main.fashionstore.Service.ProductDetailsService;
import com.main.fashionstore.Service.ProductService;
import com.main.fashionstore.Service.ShoppingCartService;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    ProductDetailsService productDetailsService;

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("items", shoppingCartService.getAllItems());
        return "user/shoping-cart";
    }

    @GetMapping("/add/{id}")
    public String addCart(@PathVariable("id") Integer id){
        ProductDetails productDetails = productDetailsService.getProductDetailById(id);
        if(productDetails != null){
            CartDetails item = new CartDetails();
            item.setCartdetails_id(productDetails.getProductdetails_id());
            item.setPrice(productDetails.getProduct().getPrice());
            item.setTotal(productDetails.getProduct().getPrice() * productDetails.getQuantity());
            item.setQuantity(productDetails.getQuantity());
            shoppingCartService.add(item);
        }
        return "redirect:/cart";
    }
}
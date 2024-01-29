package com.main.fashionstore.Controller.user;

import com.main.fashionstore.Entity.Product;
import com.main.fashionstore.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("index")
public class IndexController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "user/index";
    }
}
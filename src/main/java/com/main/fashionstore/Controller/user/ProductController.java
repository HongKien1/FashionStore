package com.main.fashionstore.Controller.user;

import com.main.fashionstore.Dao.CategoryDao;
import com.main.fashionstore.Dao.ProductDao;
import com.main.fashionstore.Dao.ProductDetailsDao;
import com.main.fashionstore.Entity.Category;
import com.main.fashionstore.Entity.Product;
import com.main.fashionstore.Entity.ProductDetails;
import com.main.fashionstore.Service.ProductDetailsService;
import com.main.fashionstore.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    ProductDetailsService productDetailsService;

    @Autowired
    ProductDetailsDao productDetailsDao;

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "user/product";
    }

    @GetMapping("/details/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
       model.addAttribute("categories", categoryDao.findAll());
       int count = 1;
       List<Map<String, Object>> colors = new ArrayList<>();
       List<Map<String, Object>> sizes = new ArrayList<>();
       for (ProductDetails productDetail : productDetailsService.findByProductId(id)) {
           if (count == 1) {
               model.addAttribute("detail_id", productDetail.getProduct().getProduct_id());
               model.addAttribute("detail_image", productDetail.getProduct().getImage());
               model.addAttribute("detail_name", productDetail.getProduct().getName());
               model.addAttribute("detail_price", productDetail.getProduct().getPrice());

           }
           Integer colorId = productDetail.getColor().getColor_id();
           String colorName = productDetail.getColor().getColor();

           if (!colors.stream().anyMatch(map -> map.containsKey("colorId") && map.get("colorId").equals(colorId))) {
               Map<String, Object> colorInfo = new HashMap<>();
               colorInfo.put("colorId", colorId);
               colorInfo.put("colorName", colorName);
               colors.add(colorInfo);
           }

           Integer sizeId = productDetail.getSize().getSize_id();
           String sizeName = productDetail.getSize().getSize_name();

           if (!sizes.stream().anyMatch(map -> map.containsKey("sizeId") &&
                   map.get("sizeId").equals(sizeId))) {
               Map<String, Object> sizeInfo = new HashMap<>();
               sizeInfo.put("sizeId", sizeId);
               sizeInfo.put("sizeName", sizeName);
               sizes.add(sizeInfo);
           }

           count++;
       }
       model.addAttribute("sizes", sizes);
       model.addAttribute("colors", colors);
//        model.addAttribute("cartCount", cartDetailService.countCartDetail(getCartCount()));
        return "user/product-detail";
    }
}

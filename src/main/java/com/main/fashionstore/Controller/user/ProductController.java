package com.main.fashionstore.Controller.user;

import com.main.fashionstore.Dao.CategoryDao;
import com.main.fashionstore.Dao.ProductDetailsDao;
import com.main.fashionstore.Entity.Account;
import com.main.fashionstore.Entity.Cart;
import com.main.fashionstore.Entity.CartDetails;
import com.main.fashionstore.Entity.Product;
import com.main.fashionstore.Entity.ProductDetails;
import com.main.fashionstore.Service.CartDetailsService;
import com.main.fashionstore.Service.CartService;
import com.main.fashionstore.Service.ParamService;
import com.main.fashionstore.Service.ProductDetailsService;
import com.main.fashionstore.Service.ProductService;
import com.main.fashionstore.Service.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @Autowired
    CartService cartService;

    @Autowired
    ParamService paramService;
    
    @Autowired
    SessionService
            sessionService;

    @Autowired
    CartDetailsService cartDetailsService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "user/product";
    }

    @RequestMapping("/details/{id}")
    public String detail(@PathVariable("id") Integer Proid, Model model) {

    //    model.addAttribute("categories", categoryDao.findAll());
       int count = 1;
       List<Map<String, Object>> colors = new ArrayList<>();
       List<Map<String, Object>> sizes = new ArrayList<>();
       for (ProductDetails productDetail : productDetailsService.findByProductId(Proid)) {
           if (count == 1) {
               model.addAttribute("pro_id", productDetail.getProduct().getProduct_id());
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

    @PostMapping("/addToCart")
    public String detailAdd(Model model) {
        Integer size = paramService.getInt("size", 0);
        Integer color = paramService.getInt("color", 0);
        Integer pID = paramService.getInt("productId", 0);

        System.out.println(size);
        Double total = null;
        Integer qty = paramService.getInt("qty", 1);

        Account user = sessionService.get("accountLogin");
        Cart cart= cartService.findCartIdByAccountId(user.getAccount_id());
        System.out.println("productDID " + pID + "size " + size + "color " + color + "Qty " + qty);
        ProductDetails productD = productDetailsService.findProductDetailsIdByColorSizeProductId(size, color, pID);
        if (productD != null) {
            System.out.println("productID " + pID + "SL proD " + productD.getQuantity() + "size " + size + "color "
                    + color + "Qty " + qty);

            // tìm CartDetailEntity
            CartDetails cartDetailEntity = cartDetailsService
                    .findCartDetailIdByCartIdAndProductDetailId(productD.getProductdetails_id(),
                            cart.getCart_id());

            if (cartDetailEntity != null) {
                // Nếu CartDetailEntity tồn tại, hãy cập nhật số lượng của nó
                cartDetailEntity.setQuantity(cartDetailEntity.getQuantity() + qty);
                cartDetailsService.updateCartDetails(cartDetailEntity);

                // In thông tin cập nhật để xác minh
                System.out.println("Updated CartDetail ID: " + cartDetailEntity.getCartdetails_id());
                System.out.println("Updated Quantity: " + cartDetailEntity.getQuantity());

            } else {
                // Nếu CartDetailEntity không tồn tại, hãy tạo một cái mới
                total = productD.getProduct().getPrice() * qty;
                cartDetailEntity = new CartDetails(100, qty,total, productD, cart);
                cartDetailsService.addToCart(cartDetailEntity);
            }
        }
        return "redirect:/user/detail";
    }

    public Integer getCartCount() {
        Cart cart = new Cart();
        if (sessionService.get("accountLogin") != null) {
            Account user = sessionService.get("accountLogin");
            cart = cartService.findCartIdByAccountId(user.getAccount_id());
        }
        return cart.getCart_id();
    }

}

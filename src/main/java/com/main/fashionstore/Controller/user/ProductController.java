package com.main.fashionstore.Controller.user;

import com.main.fashionstore.Dao.CartDao;
import com.main.fashionstore.Dao.CartDetailsDao;
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
import java.util.Optional;

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
    SessionService sessionService;

    @Autowired
    CartDetailsService cartDetailsService;

    @Autowired
    CartDetailsDao cartDetailsDao;

    @Autowired
    CartDao cartDao;

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "user/product";
    }

    @RequestMapping("/details/{id}")
    public String detail(@PathVariable("id") Integer Proid, Model model) {

        // model.addAttribute("categories", categoryDao.findAll());
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
        // model.addAttribute("cartCount",
        // cartDetailService.countCartDetail(getCartCount()));
        return "user/product-detail";
    }

    @PostMapping("/addToCart")
    public String detailAdd(Model model) {
        Account user = (Account) sessionService.get("account");
        
        if (user != null) {
            Integer size = paramService.getInt("size", 0);
            Integer color = paramService.getInt("color", 0);
            Integer pID = paramService.getInt("productId", 0);
            Integer qty = paramService.getInt("qty", 1);

            Optional<Cart> cart = cartService.findByAccount(user);
 
            if(cart == null) {
                Cart cart1 = new Cart(null, user, null);
                cartDao.save(cart1);
            }

            ProductDetails productD = productDetailsDao.findProductDetailsByColorSizeProductId(color, size, pID);

            if (productD != null) {

                Optional<CartDetails> cartDetailEntity = cartDetailsService
                        .findCartDetailIdByCartIdAndProductDetailId(cart.get().getCart_id(),
                                productD.getProductdetails_id());

                if (cartDetailEntity.isEmpty()) {
                    CartDetails cartDetails = new CartDetails();
                    cartDetails.setQuantity(qty);
                    cartDetails.setCart(cart.get());
                    cartDetails.setProductdetails(productD);
                    cartDetails.setTotal(qty * productD.getProduct().getPrice());
                    cartDetailsService.addToCart(cartDetails);

                } else {
                    // Nếu CartDetailEntity tồn tại, hãy cập nhật số lượng của nó
                    cartDetailEntity.get().setQuantity(cartDetailEntity.get().getQuantity() + qty);
                    cartDetailsService.updateCartDetails(cartDetailEntity.get());
                }
            }
            return "redirect:/index";
        } else {
            // Xử lý trường hợp người dùng chưa đăng nhập vào hệ thống
            // Điều hướng hoặc hiển thị thông báo lỗi tùy thuộc vào yêu cầu của bạn
            return "redirect:/account/login";// Ví dụ: chuyển hướng đến trang đăng nhập
        }
    }

    // public Integer getCartCount() {
    //     Cart cart = new Cart();
    //     if (sessionService.get("account") != null) {
    //         Account user = sessionService.get("account");
    //         cart = cartService.findCartIdByAccountId(user.getAccount_id().);
    //     }
    //     return cart.getCart_id();
    // }

}

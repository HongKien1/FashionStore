package com.main.fashionstore.Controller.user;

import com.main.fashionstore.Dao.AccountDao;
import com.main.fashionstore.Dao.CategoryDao;
import com.main.fashionstore.Dao.ProductDetailsDao;
import com.main.fashionstore.Entity.Account;
import com.main.fashionstore.Entity.Cart;
import com.main.fashionstore.Entity.CartDetails;
import com.main.fashionstore.Entity.Product;
import com.main.fashionstore.Entity.ProductDetails;
import com.main.fashionstore.Service.*;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.*;

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
    AccountDao accountDao;

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

    /**
     * Thêm sản phẩm vào giỏ hàng
     *
     * @param model
     * @return
     */
    @PostMapping("/addToCart")
    public String detailAdd(
            @RequestParam("sizeId") Integer sizeId,
            @RequestParam("colorId") Integer colorId,
            @RequestParam("productId") Integer productId,
            @RequestParam("qty") Integer qty,
            Model model) {

        Double total = null;

        String username = sessionService.get("account");
            Cart cart = new Cart();
        if (username != null) {
            Optional<Account> user = accountDao.findByUsername(username);
            cart = cartService.findCartIdByAccountId(user.get().getAccount_id());

            if(cart == null){
                cart = new Cart();
                cart.setAccount(user.get());
                cartService.saveCart(cart);

                System.out.println("Tạo giỏ hàng mới");
                // Thêm sản phẩm mới vào giỏ hàng
                CartDetails cartDetails = new CartDetails();
                cartDetails.setCart(cart);
                cartDetails.setQuantity(qty);
                cartDetails.setTotal(total);
                cartDetails.setProductdetails(productDetailsDao.findProductDetailsByColorSizeProductId(colorId, sizeId, productId));
                cartDetailsService.addToCart(cartDetails);
            }else{
                System.out.println("Tạo giỏ hàng mới");
                Product product = productService.getProductById(productId);
                // Thêm sản phẩm mới vào giỏ hàng
                CartDetails cartDetails = new CartDetails();
                cartDetails.setCart(cart);
                cartDetails.setQuantity(qty);
                cartDetails.setTotal(product.getPrice() * qty);
                cartDetails.setProductdetails(productDetailsDao.findProductDetailsByColorSizeProductId(colorId, sizeId, productId));
                cartDetails.setProduct(product);
                cartDetailsService.addToCart(cartDetails);
            }

            return "redirect:/cart";
        } else {
            System.out.println("Vui lòng đăng nhập tài khoản");
            return "redirect:/product/details/" + productId;
        }
    }

}

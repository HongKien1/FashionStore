package com.main.fashionstore.Controller.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.fashionstore.Entity.Account;
import com.main.fashionstore.Entity.Cart;
import com.main.fashionstore.Entity.CartDetails;
import com.main.fashionstore.Service.CartDetailsService;
import com.main.fashionstore.Service.CartService;
import com.main.fashionstore.Service.SessionService;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    CartDetailsService cartDetailsService;

    @Autowired
    SessionService sessionService;

    @Autowired
    CartService cartService;

    @GetMapping("")
    public String index(Model model) {
        Account user = (Account) sessionService.get("account"); // Lấy thông tin người dùng từ session
        if (user != null) {
            // Nếu người dùng đã đăng nhập, lấy thông tin giỏ hàng của họ từ cơ sở dữ liệu
            Optional<Cart> cart = cartService.findByAccount(user); // Giả sử có phương thức tương ứng trong CartService

            if (cart != null) {
                List<CartDetails> cartDetails = cartDetailsService.getAllCartDetails();
                model.addAttribute("cartDetails", cartDetails);
            }
        }
        return "user/shoping-cart";
    }

    @PostMapping("/updateQuantity")
    @ResponseBody
    public String updateQuantity(@RequestParam("cartDetailId") int cartDetailId,
                                 @RequestParam("quantity") int quantity) {
        // Tìm thông tin chi tiết giỏ hàng dựa trên cartDetailId
        CartDetails cartDetail = cartDetailsService.getCartDetailsById(cartDetailId);
    
        if (cartDetail != null) {
            // Cập nhật số lượng sản phẩm
            cartDetail.setQuantity(quantity);
            cartDetailsService.updateCartDetails(cartDetail);
            return "Success";
        } else {    
            return "Error";
        }
    }

    @PostMapping("/deleteCartDetail")
    public String deleteCartDetail(@RequestParam("cartDetailId") int cartDetailId) {
        // Thực hiện xóa chi tiết giỏ hàng dựa trên cartDetailId
        boolean isDeleted = cartDetailsService.deleteCartDetails(cartDetailId);


        if (isDeleted) {
            return "success";

        } else {
            return "Error";
        }
    }



}
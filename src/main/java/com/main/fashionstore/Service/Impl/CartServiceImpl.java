package com.main.fashionstore.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.fashionstore.Dao.CartDao;
import com.main.fashionstore.Dao.CartDetailsDao;
import com.main.fashionstore.Entity.Account;
import com.main.fashionstore.Entity.Cart;
import com.main.fashionstore.Entity.CartDetails;
import com.main.fashionstore.Entity.ProductDetails;
import com.main.fashionstore.Service.CartService;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    @Autowired
    CartDetailsDao cartDetailsDao;

    @Override
    public Cart createCart(Account account) {
        Cart cart = new Cart();
        cart.setAccount(account);
        return cartDao.save(cart);
    }

    @Override
    public Cart getCartById(Integer cartId) {
        return cartDao.findById(cartId).orElse(null);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartDao.findAll();
    }

    @Override
    public void updateCart(CartDetails cartDetails) {
        if (cartDetailsDao.existsById(cartDetails.getCartdetails_id())) {
            cartDetailsDao.save(cartDetails);
        }
    }

    @Override
    public void deleteCart(Integer cartId) {
        cartDao.deleteById(cartId);
    }

    @Override
    public void addToCart(CartDetails cartDetails) {
        // Lấy thông tin sản phẩm và giỏ hàng từ chi tiết giỏ hàng
        ProductDetails productDetails = cartDetails.getProductdetails();
        Cart cart = cartDetails.getCart();

        // Kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
        CartDetails existingCartDetails = cartDetailsDao.findByCartAndProductDetails(cart, productDetails);

        if (existingCartDetails != null) {
            // Nếu sản phẩm đã có trong giỏ hàng, cập nhật số lượng
            existingCartDetails.setQuantity(existingCartDetails.getQuantity() + cartDetails.getQuantity());
            cartDetailsDao.save(existingCartDetails);
        } else {
            // Nếu sản phẩm chưa có trong giỏ hàng, thêm mới vào giỏ hàng

            cartDetailsDao.save(cartDetails);
        }
    }

    @Override
    public Optional<Cart> findByAccount(Account account) {
        return cartDao.findByAccount(account);
    }

}

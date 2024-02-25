package com.main.fashionstore.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.fashionstore.Dao.CartDetailsDao;
import com.main.fashionstore.Entity.Cart;
import com.main.fashionstore.Entity.CartDetails;
import com.main.fashionstore.Service.CartDetailsService;

import java.util.List;
import java.util.Optional;

@Service
public class CartDetailsServiceImpl implements CartDetailsService {

    @Autowired
    CartDetailsDao cartDetailsDao;

    @Override
    public CartDetails addToCart(CartDetails cartDetails) {
        // Thêm chi tiết giỏ hàng vào cơ sở dữ liệu
        return cartDetailsDao.save(cartDetails);
    }

    @Override
    public CartDetails updateCartDetails(CartDetails cartDetails) {
        // Cập nhật chi tiết giỏ hàng trong cơ sở dữ liệu
        return cartDetailsDao.save(cartDetails);
    }

    @Override
    public boolean deleteCartDetails(Integer cartDetailsId) {
        // Xóa chi tiết giỏ hàng từ cơ sở dữ liệu
        cartDetailsDao.deleteById(cartDetailsId);
        return false;
    }

    @Override
    public List<CartDetails> getAllCartDetails() {
        // Lấy tất cả chi tiết giỏ hàng từ cơ sở dữ liệu
        return cartDetailsDao.findAll();
    }

    @Override
    public CartDetails getCartDetailsById(Integer cartDetailsId) {
        // Lấy chi tiết giỏ hàng dựa trên ID từ cơ sở dữ liệu
        return cartDetailsDao.findById(cartDetailsId).orElse(null);
    }

    @Override
    public List<CartDetails> getCartDetailsByCart(Cart cart) {
        // Lấy tất cả chi tiết giỏ hàng dựa trên giỏ hàng từ cơ sở dữ liệu
        return cartDetailsDao.findByCart(cart);
    }

    @Override
    public Optional<CartDetails> findCartDetailIdByCartIdAndProductDetailId(Integer cartId, Integer productDetailId) {
        return cartDetailsDao.findCartDetailIdByCartIdAndProductDetailId(cartId, productDetailId);
    }

}

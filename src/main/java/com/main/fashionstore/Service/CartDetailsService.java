package com.main.fashionstore.Service;

import java.util.List;

import com.main.fashionstore.Entity.Cart;
import com.main.fashionstore.Entity.CartDetails;

public interface CartDetailsService {

    CartDetails addToCart(CartDetails cartDetails);

    CartDetails updateCartDetails(CartDetails cartDetails);

    void deleteCartDetails(Integer cartDetailsId);

    List<CartDetails> getAllCartDetails();

    CartDetails getCartDetailsById(Integer cartDetailsId);

    List<CartDetails> getCartDetailsByCart(Cart cart);

    CartDetails findCartDetailIdByCartIdAndProductDetailId(Integer cartId, Integer productDetailId);
}

package com.main.fashionstore.Service;
import java.util.List;

import com.main.fashionstore.Entity.Account;
import com.main.fashionstore.Entity.Cart;
import com.main.fashionstore.Entity.CartDetails;


public interface CartService {

    Cart createCart(Account account);

    Cart getCartById(Integer cartId);

    List<Cart> getAllCarts();

    void updateCart(CartDetails cartDetail);

    void deleteCart(Integer cartId);

    void addToCart(CartDetails cartDetails);

    Cart findCartIdByAccountId(Integer accountId);

    void saveCart(Cart cart);
}

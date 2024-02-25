package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Cart;
import com.main.fashionstore.Entity.CartDetails;
import com.main.fashionstore.Entity.ProductDetails;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailsDao extends JpaRepository<CartDetails, Integer> {

        @Query("SELECT cd FROM CartDetails cd WHERE cd.cart = :cart AND cd.productdetails = :productDetails")
        CartDetails findByCartAndProductDetails(@Param("cart") Cart cart,
                        @Param("productDetails") ProductDetails productDetails);

        @Query("SELECT cd FROM CartDetails cd WHERE cd.cart = :cart")
        List<CartDetails> findByCart(@Param("cart") Cart cart);

        @Query("SELECT cd FROM CartDetails cd " +
                        "WHERE cd.productdetails = :productDetails " +
                        "AND cd.cart = :cart")
        List<CartDetails> findByProductDetailsAndCart(
                        @Param("productDetails") ProductDetails productDetails,
                        @Param("cart") Cart cart);

        @Query(value = "SELECT cd.* FROM CartDetails cd" +
                "                        WHERE cd.cart_id = :cartId AND" +
                "                        cd.productdetails_id = :productDetailId", nativeQuery = true)
        Optional<CartDetails> findCartDetailIdByCartIdAndProductDetailId(@Param("cartId") Integer cartId,
                        @Param("productDetailId") Integer productDetailId);


}

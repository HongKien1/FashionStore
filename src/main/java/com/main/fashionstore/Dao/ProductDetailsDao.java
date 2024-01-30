package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailsDao extends JpaRepository<ProductDetails, Integer> {

    @Query("SELECT pd FROM ProductDetails pd WHERE pd.product.product_id = :productId")
    List<ProductDetails> findByProductId(@Param("productId") Integer productId);

}
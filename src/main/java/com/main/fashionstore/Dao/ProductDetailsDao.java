package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailsDao extends JpaRepository<ProductDetails, Integer> {
}

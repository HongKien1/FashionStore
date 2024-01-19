package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsDao extends JpaRepository<ProductDetails, Integer> {
}

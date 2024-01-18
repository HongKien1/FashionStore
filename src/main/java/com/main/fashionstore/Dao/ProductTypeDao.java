package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeDao extends JpaRepository<ProductType, Integer> {
}

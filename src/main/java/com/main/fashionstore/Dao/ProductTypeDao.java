package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeDao extends JpaRepository<ProductType, Integer> {
}

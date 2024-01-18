package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
}

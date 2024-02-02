package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
        
}

package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandDao extends JpaRepository<Brand, Integer> {
}

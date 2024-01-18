package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {
}

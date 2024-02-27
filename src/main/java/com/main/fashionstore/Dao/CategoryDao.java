package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Category;
import com.main.fashionstore.Entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

}

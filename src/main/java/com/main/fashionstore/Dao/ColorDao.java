package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorDao extends JpaRepository<Color, Integer> {
}

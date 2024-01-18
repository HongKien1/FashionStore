package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorDao extends JpaRepository<Color, Integer> {
}

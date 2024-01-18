package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeDao extends JpaRepository<Size, Integer> {
}

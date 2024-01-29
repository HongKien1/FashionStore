package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeDao extends JpaRepository<Size, Integer> {
}

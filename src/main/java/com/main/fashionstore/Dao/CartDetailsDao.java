package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.CartDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailsDao extends JpaRepository<CartDetails, Integer> {
}

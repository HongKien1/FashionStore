package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDao extends JpaRepository<Cart, Integer> {
}

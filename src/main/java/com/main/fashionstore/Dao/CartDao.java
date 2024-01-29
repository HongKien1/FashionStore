package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {
}

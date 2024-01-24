package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.CartDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailsDao extends JpaRepository<CartDetails, Integer> {
}

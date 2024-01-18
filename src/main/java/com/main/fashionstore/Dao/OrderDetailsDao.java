package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsDao extends JpaRepository<OrderDetails, Integer> {
}

package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusDao extends JpaRepository<OrderStatus, Integer> {
}

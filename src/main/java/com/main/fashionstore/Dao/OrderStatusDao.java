package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusDao extends JpaRepository<OrderStatus, Integer> {

}

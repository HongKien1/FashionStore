package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer>  {
}

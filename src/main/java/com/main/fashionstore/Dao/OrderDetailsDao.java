package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsDao extends JpaRepository<OrderDetails, Integer> {
}

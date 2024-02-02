package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.OrderDetails;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsDao extends JpaRepository<OrderDetails, Integer> {

//  // Sử dụng câu lệnh query để lấy danh sách chi tiết đơn hàng dựa trên ID đơn hàng
//     @Query("SELECT od FROM OrderDetails od WHERE od.order.orderId = :orderId")
//     List<OrderDetails> findByOrderId(@Param("orderId") Integer orderId);

}

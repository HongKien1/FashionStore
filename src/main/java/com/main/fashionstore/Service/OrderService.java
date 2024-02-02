package com.main.fashionstore.Service;
import java.util.List;

import com.main.fashionstore.Entity.Order;

public interface OrderService {

    Order placeOrder(Order order);

    Order getOrderById(Integer orderId);

    List<Order> getAllOrders();

    void updateOrder(Order order);

    void deleteOrder(Integer orderId);
}

package com.main.fashionstore.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.fashionstore.Dao.OrderDao;
import com.main.fashionstore.Entity.Order;
import com.main.fashionstore.Service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Order placeOrder(Order order) {
        // Thực hiện các bước liên quan đến thanh toán hoặc lưu đơn hàng vào cơ sở dữ liệu
        // ...

        // Lưu đơn hàng vào cơ sở dữ liệu
        return orderDao.save(order);
    }

    @Override
    public Order getOrderById(Integer orderId) {
        return orderDao.findById(orderId).orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    @Override
    public void updateOrder(Order order) {
        if (orderDao.existsById(order.getOrder_id())) {
            orderDao.save(order);
        }
    }

    @Override
    public void deleteOrder(Integer orderId) {
        orderDao.deleteById(orderId);
    }
}

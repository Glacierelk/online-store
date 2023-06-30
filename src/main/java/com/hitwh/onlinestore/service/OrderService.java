package com.hitwh.onlinestore.service;

import com.hitwh.onlinestore.bean.Order;
import com.hitwh.onlinestore.dao.OrderDAO;

import java.util.List;

public interface OrderService {
    /**
     * 获取所有订单数据
     * @return
     */
    List<Order> getAllOrders();

    /**
     * 获取某个用户的所有订单
     * @param userId
     * @return
     */
    List<Order> getOrdersByUserId(String userId);
}

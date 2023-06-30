package com.hitwh.onlinestore.dao;

import com.hitwh.onlinestore.bean.Order;

import java.util.List;

public interface OrderDAO {
    /**
     * 获取所有订单数据
     * @return
     */
    List<Order> getAllOrders();
}


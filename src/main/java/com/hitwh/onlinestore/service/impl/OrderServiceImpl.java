package com.hitwh.onlinestore.service.impl;

import com.hitwh.onlinestore.bean.Order;
import com.hitwh.onlinestore.dao.CategoryDAO;
import com.hitwh.onlinestore.dao.OrderDAO;
import com.hitwh.onlinestore.dao.impl.CategoryDAOImpl;
import com.hitwh.onlinestore.dao.impl.OrderDAOImpl;
import com.hitwh.onlinestore.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO = new OrderDAOImpl();
    @Override
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }
}

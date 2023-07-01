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

    @Override
    public List<Order> getOrdersByUserId(String userId) {
        return orderDAO.getOrdersByUserId(userId);
    }

    @Override
    public boolean updateStatus(int oid, int status) {

        return orderDAO.updateStatus(oid, status);
    }

    @Override
    public boolean deleteOrder(int oid) {
        return orderDAO.deleteOrder(oid);
    }
}

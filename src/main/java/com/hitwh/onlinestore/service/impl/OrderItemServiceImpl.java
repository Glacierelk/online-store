package com.hitwh.onlinestore.service.impl;

import com.hitwh.onlinestore.bean.OrderItem;
import com.hitwh.onlinestore.dao.OrderDAO;
import com.hitwh.onlinestore.dao.impl.OrderDAOImpl;
import com.hitwh.onlinestore.service.OrderItemService;

import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {
    private final OrderDAO orderDAO = new OrderDAOImpl();
    @Override
    public List<OrderItem> getOrderItemsByOrderId(int oid) {
        return orderDAO.getOrderItemsByOrderId(oid);
    }
}

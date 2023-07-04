package com.hitwh.onlinestore.service.impl;

import com.hitwh.onlinestore.bean.OrderItem;
import com.hitwh.onlinestore.dao.OrderDAO;
import com.hitwh.onlinestore.dao.ProductDAO;
import com.hitwh.onlinestore.dao.impl.OrderDAOImpl;
import com.hitwh.onlinestore.dao.impl.ProductDAOImpl;
import com.hitwh.onlinestore.service.OrderItemService;

import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {
    private final OrderDAO orderDAO = new OrderDAOImpl();
    private final ProductDAO productDAO = new ProductDAOImpl();
    @Override
    public List<OrderItem> getOrderItemsByOrderId(int oid) {
        List<OrderItem> orderItems = orderDAO.getOrderItemsByOrderId(oid);
        for (OrderItem orderItem : orderItems) {
            orderItem.setProductImage(productDAO.getOneImageByProductId(orderItem.getPid()));
        }
        return orderItems;
        }
}

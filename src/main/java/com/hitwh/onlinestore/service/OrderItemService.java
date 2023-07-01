package com.hitwh.onlinestore.service;

import com.hitwh.onlinestore.bean.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> getOrderItemsByOrderId(int oid);
}

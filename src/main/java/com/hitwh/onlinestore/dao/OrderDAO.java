package com.hitwh.onlinestore.dao;

import com.hitwh.onlinestore.bean.Order;
import com.hitwh.onlinestore.bean.OrderItem;

import java.util.List;

public interface OrderDAO {
    /**
     * 获取所有订单数据
     * @return
     */
    List<Order> getAllOrders();
    /**
     * 获取某个用户的所有订单
     */
    List<Order> getOrdersByUserId(String userId);
    /**
     * 根据订单id获取订单商品
     */
    List<OrderItem> getOrderItemsByOrderId(int orderId);

    /**
     * 更新某个订单的状态（0待付款、1待发货、2待收货、3待评价）
     * @param oid
     * @param status
     * @return
     */
    boolean updateStatus(int oid, int status);

    /**
     * 删除某个订单
     * @param oid
     * @return
     */
    boolean deleteOrder(int oid);

    /**
     * 创建订单
     * @param order
     * @return
     */
    boolean createOrder(Order order);
}


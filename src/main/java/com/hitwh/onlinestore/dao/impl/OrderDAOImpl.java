package com.hitwh.onlinestore.dao.impl;

import com.hitwh.onlinestore.bean.Order;
import com.hitwh.onlinestore.bean.OrderItem;
import com.hitwh.onlinestore.dao.OrderDAO;
import com.hitwh.onlinestore.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Order> getAllOrders() {
//        System.out.println("getAllOrders");
        String sql = "SELECT\n" +
                "    o.id,\n" +
                "    o.order_code,\n" +
                "    o.address,\n" +
                "    o.post,\n" +
                "    o.receiver,\n" +
                "    o.receiver_tel,\n" +
                "    o.user_message,\n" +
                "    o.create_date,\n" +
                "    o.pay_date,\n" +
                "    o.delivery_date,\n" +
                "    o.confirm_date,\n" +
                "    o.uid,\n" +
                "    o.status,\n" +
                "    SUM(oi.count) AS productCount,\n" +
                "    SUM(p.promote_price * oi.count) AS totalPrice\n" +
                "FROM\n" +
                "    online_store.`order` AS o\n" +
                "        LEFT JOIN\n" +
                "    online_store.order_item AS oi ON o.id = oi.oid\n" +
                "        LEFT JOIN\n" +
                "    online_store.product AS p ON oi.pid = p.id\n" +
                "GROUP BY\n" +
                "    o.id;";
        try {
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            System.out.println("查询所有订单失败");
            return null;
        }
    }

    @Override
    public List<Order> getOrdersByUserId(String userId) {
        String sql = "SELECT\n" +
                "    o.id,\n" +
                "    o.order_code,\n" +
                "    o.receiver_tel,\n" +
                "    o.user_message,\n" +
                "    o.create_date,\n" +
                "    o.pay_date,\n" +
                "    o.delivery_date,\n" +
                "    o.confirm_date,\n" +
                "    o.uid,\n" +
                "    o.status,\n" +
                "    SUM(oi.count) AS productCount,\n" +
                "    SUM(p.promote_price * oi.count) AS total_price\n" +
                "FROM\n" +
                "    online_store.`order` AS o\n" +
                "        LEFT JOIN\n" +
                "    online_store.order_item AS oi ON o.id = oi.oid\n" +
                "        LEFT JOIN\n" +
                "    online_store.product AS p ON oi.pid = p.id\n" +
                "where o.uid = ?\n" +
                "GROUP BY\n" +
                "    o.id;";
        try {
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class), userId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(int orderId) {
        String sql = "SELECT\n" +
                "    oi.id ,\n" +
                "    oi.pid,\n" +
                "    oi.oid,\n" +
                "    p.name,\n" +
                "    p.original_price,\n" +
                "    p.promote_price,\n" +
                "    oi.count\n" +
                "FROM\n" +
                "    online_store.order_item AS oi\n" +
                "        LEFT JOIN\n" +
                "    online_store.product AS p ON oi.pid = p.id\n" +
                "WHERE\n" +
                "    oi.oid = ?;";
        try {
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(OrderItem.class), orderId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateStatus(int oid, int status) {
        String sql = "UPDATE online_store.`order` SET status = ? WHERE id = ?;";
        String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        int status1;//（0待付款、1待发货、2待收货、3待评价、4订单完成）
        if (status == 4) {
            return false;
        }else {
            status1 = status + 1;
        }
        try {
            jdbcTemplate.update(sql, status1, oid);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        if(status != 3){
            switch (status) {
                case 0:
                    sql = "UPDATE online_store.`order` SET pay_date = ? WHERE id = ?;";
                    break;
                case 1:
                    sql = "UPDATE online_store.`order` SET delivery_date = ? WHERE id = ?;";
                    break;
                case 2:
                    sql = "UPDATE online_store.`order` SET confirm_date = ? WHERE id = ?;";
                    break;
            }
            try {
                jdbcTemplate.update(sql, currentDate, oid);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean deleteOrder(int oid) {

        String sql = "DELETE FROM online_store.`order` WHERE id = ?;";
        try {
            return jdbcTemplate.update(sql, oid) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean createOrder(Order order) {
        String sql = "INSERT INTO online_store.`order` (order_code, " +
                "receiver_tel, user_message, create_date, " +
                "uid, status) values(?,?,?,?,?,?);";
        try {
            jdbcTemplate.update(sql, order.getOrderCode(),
                    order.getReceiverTel(), order.getUserMessage(), order.getCreateDate(),
                    order.getUid(), order.getStatus());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }

        sql = "SELECT id from online_store.`order` where order_code = ?;";
        int id;
        try {
            id = jdbcTemplate.queryForObject(sql, Integer.class, order.getOrderCode());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        sql = "INSERT INTO online_store.order_item (pid, oid, count) values(?,?,?);";
        List<Object[]> batchArgsList = new ArrayList<>();
        for (OrderItem orderItem : order.getOrderItems()) {
            Object[] obj = new Object[]{orderItem.getPid(), id, orderItem.getCount()};
            batchArgsList.add(obj);
        }
        try {
            jdbcTemplate.batchUpdate(sql, batchArgsList);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

package com.hitwh.onlinestore.dao.impl;

import com.hitwh.onlinestore.bean.Order;
import com.hitwh.onlinestore.dao.OrderDAO;
import com.hitwh.onlinestore.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Order> getAllOrders() {
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
                "    COUNT(oi.id) AS amount,\n" +
                "    SUM(p.promote_price * oi.number) AS totalPrice\n" +
                "FROM\n" +
                "    online_store.`order` AS o\n" +
                "        LEFT JOIN\n" +
                "    online_store.order_item AS oi ON o.id = oi.oid\n" +
                "        LEFT JOIN\n" +
                "    online_store.product AS p ON oi.pid = p.id\n" +
                "GROUP BY\n" +
                "    o.id;";
        try {
            return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Order.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}

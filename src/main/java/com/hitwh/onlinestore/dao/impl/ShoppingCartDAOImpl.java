package com.hitwh.onlinestore.dao.impl;

import com.hitwh.onlinestore.bean.ShoppingCart;
import com.hitwh.onlinestore.dao.ShoppingCartDAO;
import com.hitwh.onlinestore.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ShoppingCartDAOImpl implements ShoppingCartDAO {
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<ShoppingCart> queryByUserId(Integer userId) {
        String sql = "select * from shopping_cart where uid = ? and status = 1";
        try {
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ShoppingCart.class), userId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer getCount(int id) {
        String sql = "select count(*) from shopping_cart where uid = ? and status = 1";
        try {
            return jdbcTemplate.queryForObject(sql, Integer.class, id);
        } catch (Exception e) {
            return 0;
        }
    }
}
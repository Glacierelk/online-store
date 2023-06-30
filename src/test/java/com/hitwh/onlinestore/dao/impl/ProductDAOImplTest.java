package com.hitwh.onlinestore.dao.impl;

import com.hitwh.onlinestore.bean.ProductDetails;
import com.hitwh.onlinestore.utils.JDBCUtils;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

class ProductDAOImplTest {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    void delete() {
        String sql = "delete from product where id = ?";
        int count = template.update(sql, 999);
        assertEquals(1, count);
    }

    @Test
    void queryByName() {
        String sql = "select * from product where name like ?";
        System.out.println(template.query(sql, new BeanPropertyRowMapper<>(ProductDetails.class), "%乐%"));
    }
}
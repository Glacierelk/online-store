package com.hitwh.onlinestore.dao.impl;

import com.hitwh.onlinestore.bean.ProductProperties;
import com.hitwh.onlinestore.bean.Property;
import com.hitwh.onlinestore.utils.JDBCUtils;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

class PropertyDAOImplTest {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    void getPropertyByCategoryId() {
        String sql = "select * from property where cid = 79";
        System.out.println(template.query(sql, new BeanPropertyRowMapper<>(Property.class)));
    }

    @Test
    void getPropertiesByProductId() {
        int id = 87;
        String sql = "select * from product_properties_view where pid = ?";
        System.out.println(template.query(sql, new BeanPropertyRowMapper<>(ProductProperties.class), id));
    }

    @Test
    void testGetPropertiesByProductId() {
        String sql = "SELECT \n" +
                "  COALESCE(id, '') AS id,\n" +
                "  COALESCE(pid, '') AS pid,\n" +
                "  COALESCE(name, '') AS name,\n" +
                "  COALESCE(value, '') AS value\n" +
                "FROM product_properties_view\n" +
                "WHERE pid = ?;";
        System.out.println(template.query(sql, new BeanPropertyRowMapper<>(ProductProperties.class), 1008));
    }
}
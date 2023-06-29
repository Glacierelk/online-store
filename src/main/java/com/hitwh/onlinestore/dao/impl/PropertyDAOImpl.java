package com.hitwh.onlinestore.dao.impl;

import com.hitwh.onlinestore.bean.Property;
import com.hitwh.onlinestore.dao.PropertyDAO;
import com.hitwh.onlinestore.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PropertyDAOImpl implements PropertyDAO {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Property> getPropertyByCategoryId(Integer categoryId) {
        try {
            String sql = "select * from property where cid = ?";
            return template.query(sql, new BeanPropertyRowMapper<>(Property.class), categoryId);
        } catch (Exception e) {
            return null;
        }
    }
}
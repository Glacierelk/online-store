package com.hitwh.onlinestore.dao.impl;

import com.hitwh.onlinestore.bean.Product;
import com.hitwh.onlinestore.dao.ProductDAO;
import com.hitwh.onlinestore.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<Product> homePageGetProductsByCategoryId(int categoryId) {
        try {
            String sql = "select id, name, sub_title from product where cid = ? limit 30";
            return template.query(sql, new BeanPropertyRowMapper<>(Product.class), categoryId);
        } catch (Exception e) {
            return null;
        }
    }
}

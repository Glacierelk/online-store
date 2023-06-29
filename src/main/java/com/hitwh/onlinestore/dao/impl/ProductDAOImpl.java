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

    @Override
    public boolean addProduct(Product product) {
        System.out.println("ProductDAOImpl--addProduct");
        String sql = "insert into product(name, sub_title, original_price, promote_price, stock, cid, create_date) " +
                "values(?, ?, ?, ?, ?, ?, ?)";
        int count = template.update(sql, product.getName(), product.getSubTitle(), product.getOriginalPrice(),
                product.getPromotePrice(), product.getStock(), product.getCid(), product.getCreateDate());
        return count == 1;
    }
}

package com.hitwh.onlinestore.dao.impl;

import com.hitwh.onlinestore.bean.Category;
import com.hitwh.onlinestore.bean.Product;
import com.hitwh.onlinestore.dao.CategoryDAO;
import com.hitwh.onlinestore.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public boolean addCategory(String name) {
        String sql = "insert into category(name) values(?)";
        int count = jdbcTemplate.update(sql, name);
        return count != 0;
    }

    @Override
    public Category getCategoryById(int id) {
        try {
            String sql = "select * from category where id = ?";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Category.class), id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean deleteCategoryById(int id) {
        String sql = "delete from category where id = ?";
        int count = jdbcTemplate.update(sql, id);
        return count != 0;
    }

    @Override
    public List<Category> listAllCategories() {
        try {
            String sql = "select * from category";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean deleteCategory(int id) {
        String sql = "delete from category where id = ?";
        int count = jdbcTemplate.update(sql, id);
        return count != 0;
    }

    @Override
    public List<Product> getPropertyByCid(int cid) {
        System.out.println(cid);
        try {
            String sql = "select * from product where cid  = ? ";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class),cid);
        } catch (Exception e) {
            return null;
        }
    }
}

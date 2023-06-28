package com.hitwh.onlinestore.dao.impl;

import com.hitwh.onlinestore.bean.User;
import com.hitwh.onlinestore.dao.UserDAO;
import com.hitwh.onlinestore.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void addUser(User user) {
        String sql = "insert into user(name, password, email, address) values(?, ?, ?, ?)";
        String name = user.getName();
        String password = user.getPassword();
        String email = user.getEmail();
        String address = user.getAddress();
        template.update(sql, name, password, email, address);
    }

    @Override
    public User getUserByName(String name) {
        String sql = "select id,name,password,email,address from user where name = ?";
        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public User getUserById(int id) {
        String sql = "select id,name,password,email,address from user where id = ?";
        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public User getUserByNameAndPassword(String name, String password) {
        String sql = "select id,name,password,email,address from user where name = ? and password = ?";
        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name, password);
        } catch (DataAccessException e) {
            return null;
        }

    }

    @Override
    public boolean deleteUserByName(String name) {
        String sql = "delete from user where name = ?";
        int count = template.update(sql, name);
        return count != 0;
    }

    @Override
    public int getTotal() {
        try {
            String sql = "select count(id) from user";
            return template.queryForObject(sql, Integer.class);
        } catch (Exception e) {
            return 0;
        }
    }

    //不考虑分页
    @Override
    public List<User> getUserList() {
        String sql = "select id,name,password,email,address from user";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }
}


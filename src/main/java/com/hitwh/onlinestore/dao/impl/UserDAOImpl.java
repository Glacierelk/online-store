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
        String sql = "insert into user(username, password, email, address) values(?, ?, ?, ?)";
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String address = user.getAddress();
        template.update(sql, username, password, email, address);
    }

    @Override
    public User getUserByUsername(String username) {
        String sql = "select id,username,password,email,address from user where username = ?";
        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public User getUserById(int id) {
        String sql = "select id,username,password,email,address from user where id = ?";
        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,email,address from user where username = ? and password = ?";
        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        } catch (DataAccessException e) {
            return null;
        }

    }

    @Override
    public boolean deleteUserByUsername(String username) {
        String sql = "delete from user where username = ?";
        int count = template.update(sql, username);
        return count != 0;
    }

    /**
     * 获取总记录数
     * @return
     */
    @Override
    public int getTotal() {
        try {
            String sql = "select count(id) from user";
            return template.queryForObject(sql, Integer.class);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获取用户列表，不考虑分页
     * @return
     */
    @Override
    public List<User> getUserList() {
        String sql = "select id,username,password,email,address from user";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }
}


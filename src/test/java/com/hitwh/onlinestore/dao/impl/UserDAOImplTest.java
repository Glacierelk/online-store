package com.hitwh.onlinestore.dao.impl;

import com.hitwh.onlinestore.bean.User;
import com.hitwh.onlinestore.utils.JDBCUtils;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
class UserDAOImplTest {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    void addUser() {

    }

    @Test
    void getUserByName() {
        String name = "abc";
        String sql = "select id,name,password,email,address from user where name = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), name);
        System.out.println(user);
    }

    @Test
    void getUserById() {
    }

    @Test
    void getUserByNameAndPassword() {
    }

    @Test
    void deleteUserByName() {
    }

    @Test
    void getTotal() {
    }

    @Test
    void getUserList() {
    }
}
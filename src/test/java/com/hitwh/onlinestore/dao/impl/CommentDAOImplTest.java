package com.hitwh.onlinestore.dao.impl;

import com.hitwh.onlinestore.bean.Comment;
import com.hitwh.onlinestore.utils.JDBCUtils;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

class CommentDAOImplTest {
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    void getCommentsByProductId() {
        String sql = "SELECT * FROM comment WHERE pid = ?";
        System.out.println(jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Comment.class), 87));
    }
}
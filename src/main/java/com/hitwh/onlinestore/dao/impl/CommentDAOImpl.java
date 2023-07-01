package com.hitwh.onlinestore.dao.impl;

import com.hitwh.onlinestore.bean.Comment;
import com.hitwh.onlinestore.dao.CommentDAO;
import com.hitwh.onlinestore.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CommentDAOImpl implements CommentDAO {
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Comment> getCommentsByProductId(int productId) {
        try {
            String sql = "SELECT * FROM comment_views WHERE pid = ?";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Comment.class), productId);
        } catch (Exception e) {
            return null;
        }
    }
}

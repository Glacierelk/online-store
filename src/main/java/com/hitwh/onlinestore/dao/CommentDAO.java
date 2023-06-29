package com.hitwh.onlinestore.dao;

import com.hitwh.onlinestore.bean.Comment;

import java.util.List;

public interface CommentDAO {
    public List<Comment> getCommentsByProductId(int productId);
}

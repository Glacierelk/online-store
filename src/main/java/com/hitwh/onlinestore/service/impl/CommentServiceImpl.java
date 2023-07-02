package com.hitwh.onlinestore.service.impl;

import com.hitwh.onlinestore.bean.Comment;
import com.hitwh.onlinestore.dao.CommentDAO;
import com.hitwh.onlinestore.dao.impl.CommentDAOImpl;
import com.hitwh.onlinestore.service.CommentService;

public class CommentServiceImpl implements CommentService {

    private CommentDAO commentDAO = new CommentDAOImpl();
    @Override
    public boolean addComment(Comment comment) {
        return commentDAO.addComment(comment);
    }
}

package com.hitwh.onlinestore.web.servlet;


import com.hitwh.onlinestore.bean.Comment;
import com.hitwh.onlinestore.bean.ResultInfo;
import com.hitwh.onlinestore.service.CommentService;
import com.hitwh.onlinestore.service.impl.CommentServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/comment/*")
public class CommentServlet extends BaseServlet{
    private final CommentService commentService = new CommentServiceImpl();
    public void addComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("adding comment ...");
        ResultInfo info = new ResultInfo();
        Comment comment = new Comment();
        try{
            comment.setPid(Integer.parseInt(request.getParameter("pid")));
            comment.setUid(Integer.parseInt(request.getParameter("uid")));
            comment.setContent(request.getParameter("content"));
            boolean insertFlag=commentService.addComment(comment);
            if(insertFlag)
            {
                info.setErrorMsg(null);
                info.setFlag(true);
            }
            else
            {
                info.setErrorMsg("fail to insert!(db)");
                info.setFlag(false);
            }
        }catch (Exception e)
        {
            System.out.println(e.toString());
            info.setErrorMsg("fail to insert!(Exception)");
            info.setFlag(false);
        }
        writeJsonValue(response,info);
    }

}

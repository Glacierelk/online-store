package com.hitwh.onlinestore.web;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.hitwh.onlinestore.bean.ResultInfo;
import com.hitwh.onlinestore.bean.User;
import com.hitwh.onlinestore.service.UserService;
import com.hitwh.onlinestore.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private static final UserService userService = new UserServiceImpl();
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ResultInfo info = new ResultInfo();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User exist_user = userService.login(name, password);
        if(exist_user!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", exist_user);
            info.setFlag(true);//登陆成功
        }else {
            info.setFlag(false);//登陆失败
            info.setErrorMsg("用户名或密码错误");
        }
        writeJsonValue(response, info);
    }
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ResultInfo info = new ResultInfo();
        Map<String,String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        boolean flag = userService.register(user);
        if(flag) {
            info.setFlag(true);
        }else {
            info.setFlag(false);
            info.setErrorMsg("用户名已存在");
        }
        writeJsonValue(response, info);
    }
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        //重定向到登陆页面
        response.sendRedirect(request.getContextPath()+"/#");
    }
    public void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user = (User) request.getSession().getAttribute("user");
        writeJsonValue(response, user);
    }
}

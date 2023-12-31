package com.hitwh.onlinestore.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hitwh.onlinestore.bean.ResultInfo;
import com.hitwh.onlinestore.bean.User;
import com.hitwh.onlinestore.service.UserService;
import com.hitwh.onlinestore.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private static final UserService userService = new UserServiceImpl();

    /**
     * 登陆
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ResultInfo info = new ResultInfo();
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        User exist_user = userService.login(name, password);
        if(exist_user!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", exist_user);
//            System.out.println("写入"+exist_user);
            info.setFlag(true);//登陆成功
        }else {
            info.setFlag(false);//登陆失败
            info.setErrorMsg("用户名或密码错误");
        }
        writeJsonValue(response, info);
    }

    /**
     * 注册用户，用户名唯一
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ResultInfo info = new ResultInfo();
        Map<String,String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        boolean flag = userService.register(user);
        if(flag) {
            info.setFlag(true);
        }else {
            info.setFlag(false);
            info.setErrorMsg("用户名已存在");
        }
        writeJsonValue(response, info);
    }

    /**
     * 退出登陆
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        try {
            request.getSession().invalidate();
            info.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            info.setFlag(false);
        }
        writeJsonValue(response, info);
    }


    /**
     * 获取在线用户信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession userSession = request.getSession();
        Object user = userSession.getAttribute("user");
//        System.out.println("读取"+user);
        ResultInfo info = new ResultInfo();
        if(user!=null) {
            info.setFlag(true);
            info.setData(user);
        }else {
            info.setFlag(false);
            info.setErrorMsg("获取在线用户信息失败");
        }
        System.out.println(info);
        writeJsonValue(response, info);
    }

    /**
     * 根据用户名删除用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
//        String name = request.getParameter("name");
        ResultInfo info = new ResultInfo();
        if(userService.deleteUser(id)) {
            info.setFlag(true);
        }else {
            info.setFlag(false);
            info.setErrorMsg("删除失败");
        }
        writeJsonValue(response, info);
    }
    public void getAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        try {
            info.setData(userService.getUserList());
            info.setFlag(true);
        }
        catch (Exception e){
            info.setFlag(false);
            info.setErrorMsg("获取失败");
        }
        writeJsonValue(response, info);
    }

}

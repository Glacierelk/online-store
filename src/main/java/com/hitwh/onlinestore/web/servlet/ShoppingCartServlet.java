package com.hitwh.onlinestore.web.servlet;

import com.hitwh.onlinestore.bean.ResultInfo;
import com.hitwh.onlinestore.service.ShoppingCartService;
import com.hitwh.onlinestore.service.impl.ShoppingCartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cart/*")
public class ShoppingCartServlet extends BaseServlet {
    private final ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

    /**
     * 查询用户购物车
     */
    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------show------");
        ResultInfo info = new ResultInfo();
        try {
            info.setData(shoppingCartService.getShoppingCartByUserId(
                    Integer.parseInt(request.getParameter("id"))
            ));
            info.setFlag(true);
        } catch (NumberFormatException e) {
            info.setFlag(false);
            info.setErrorMsg("请给出正确数据类型!");
        } catch (Exception e) {
            info.setFlag(false);
            info.setErrorMsg("获取失败!");
        }
        writeJsonValue(response, info);
    }

    /**
     * 获取购物车商品数量
     */
    public void getCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------getCount------");
        ResultInfo info = new ResultInfo();
        try {
            info.setData(shoppingCartService.getShoppingCartCount(
                    Integer.parseInt(request.getParameter("id"))
            ));
            info.setFlag(true);
        } catch (NumberFormatException e) {
            info.setFlag(false);
            info.setErrorMsg("请给出正确数据类型!");
        } catch (Exception e) {
            info.setFlag(false);
            info.setErrorMsg("获取失败!");
        }
        writeJsonValue(response, info);
    }
}

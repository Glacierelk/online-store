package com.hitwh.onlinestore.web.servlet;

import com.hitwh.onlinestore.bean.ResultInfo;
import com.hitwh.onlinestore.bean.ShoppingCart;
import com.hitwh.onlinestore.service.ShoppingCartService;
import com.hitwh.onlinestore.service.impl.ShoppingCartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shoppingCart/*")
public class ShoppingCartServlet extends BaseServlet {
    private final ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

    /**
     * 查询用户购物车
     */
    public void getShoppingCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------getShoppingCart------");
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

    public void addGoods(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("adding goods...");
        ShoppingCart shoppingCart = new ShoppingCart();
        ResultInfo resultInfo = new ResultInfo();
        try{
            shoppingCart.setCount(Integer.parseInt(request.getParameter("count")));
            shoppingCart.setPid(Integer.parseInt(request.getParameter("pid")));
            shoppingCart.setUid(Integer.parseInt(request.getParameter("uid")));
            shoppingCart.setStatus(1);
            boolean addFlag=shoppingCartService.addGoods(shoppingCart);
            if(addFlag){
                resultInfo.setErrorMsg(null);
                resultInfo.setFlag(true);
            }
            else
            {
                resultInfo.setErrorMsg("fail to insert!!!(db)");
                resultInfo.setFlag(false);
            }
        }catch (Exception e){
            System.out.println(e.toString());
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("fail to add goods!");
        }
        writeJsonValue(response,resultInfo);
    }

    public void deleteGoods(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int uid,pid;
        ResultInfo info = new ResultInfo();
        try{
            uid=Integer.parseInt(request.getParameter("uid"));
            pid=Integer.parseInt(request.getParameter("pid"));
            boolean delStatus=shoppingCartService.deleteGoods(uid,pid);
            if(delStatus)
            {
                info.setFlag(true);
                info.setErrorMsg(null);
            }
            else {
                info.setErrorMsg("fail to del!!!(db)");
                info.setFlag(false);
            }


        }catch (Exception e){
            info.setFlag(false);
            info.setErrorMsg("fail to del!!!");
        }
        writeJsonValue(response,info);
    }

    public void deleteGoodsByList(HttpServletRequest request,HttpServletResponse response) {

        request.getParameter("goodsList");

    }
}

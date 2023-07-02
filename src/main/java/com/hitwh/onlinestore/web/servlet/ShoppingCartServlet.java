package com.hitwh.onlinestore.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hitwh.onlinestore.bean.ResultInfo;
import com.hitwh.onlinestore.bean.ShoppingCart;
import com.hitwh.onlinestore.service.ShoppingCartService;
import com.hitwh.onlinestore.service.impl.ShoppingCartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        int id;
        ResultInfo info = new ResultInfo();
        try{
            id=Integer.parseInt(request.getParameter("id"));
            boolean delStatus=shoppingCartService.deleteGoods(id);
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

    public void deleteGoodsByList(HttpServletRequest request,HttpServletResponse response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ResultInfo info = new ResultInfo();
        try {
            List<Integer> shoppingCarts = objectMapper.readValue(request.getParameter("id"), objectMapper.getTypeFactory().constructParametricType(List.class, Integer.class));
            System.out.println(shoppingCarts);
            for(Integer item : shoppingCarts) {
                boolean delFlag=shoppingCartService.deleteGoods(item);
                if(!delFlag)
                {
                    info.setFlag(false);
                    info.setErrorMsg("fail to delete list!!!(db)");
                    break;
                }
            }
            info.setFlag(true);
            info.setErrorMsg(null);
        }catch (Exception e) {
            System.out.println(e.toString());
            info.setFlag(false);
            info.setErrorMsg("fail to delete list!!!");
        }
        writeJsonValue(response,info);
    }

    public void alterGoodsNumber(HttpServletRequest request,HttpServletResponse response) throws IOException {
        ShoppingCart shoppingCart = new ShoppingCart();
        ResultInfo info = new ResultInfo();
        try {
            shoppingCart.setPid(Integer.parseInt(request.getParameter("pid")));
            shoppingCart.setUid(Integer.parseInt(request.getParameter("uid")));
            shoppingCart.setCount(Integer.parseInt(request.getParameter("count")));
            boolean alterFlag = shoppingCartService.alterGoodNumber(shoppingCart);
            if(alterFlag){
                info.setFlag(true);
                info.setErrorMsg(null);
            }
            else
            {
                info.setFlag(false);
                info.setErrorMsg("fail to alter!!!(db)");
            }
        }catch (Exception e){
            System.out.println(e.toString());
            info.setErrorMsg("fail to alter!!!");
            info.setFlag(false);
        }
        writeJsonValue(response,info);
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

    /*
    * 检查商品是否在购物车中
    * */
    public void checkCartStatus(HttpServletRequest request,HttpServletResponse response) throws IOException {
        ResultInfo info = new ResultInfo();
        System.out.println("checking status ......");

        try {
            int uid=Integer.parseInt(request.getParameter("uid"));
            int pid=Integer.parseInt(request.getParameter("pid"));
            boolean cartFlag=shoppingCartService.checkCartStatus(pid,uid);
            if(cartFlag){
                info.setFlag(true);//flag表示的是是否查询到
                info.setErrorMsg(null);
                info.setData(true); //data表示到的是查询到的状态是什么
            }
            else {
                info.setErrorMsg("fail to check!!!(db)");
                info.setFlag(true);
                info.setData(false);
            }
        }catch (Exception e) {
            System.out.println(e.toString());
            info.setErrorMsg("fail to check!!!");
            info.setFlag(false);
            info.setData(null);
        }
        writeJsonValue(response,info);
    }


}

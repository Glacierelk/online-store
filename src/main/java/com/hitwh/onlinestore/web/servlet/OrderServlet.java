package com.hitwh.onlinestore.web.servlet;



import com.hitwh.onlinestore.bean.Order;
import com.hitwh.onlinestore.bean.ResultInfo;
import com.hitwh.onlinestore.service.OrderItemService;
import com.hitwh.onlinestore.service.OrderService;
import com.hitwh.onlinestore.service.impl.OrderItemServiceImpl;
import com.hitwh.onlinestore.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/order/*")
public class OrderServlet extends BaseServlet {
    private final OrderService orderService = new OrderServiceImpl();
    private final OrderItemService orderItemService = new OrderItemServiceImpl();

    /**
     * 获取所有订单数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void getAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        List<Order> orders = orderService.getAllOrders();
        //检查返回的订单是否为空
        if(orders == null){
            info.setFlag(false);
            info.setErrorMsg("获取订单失败");
        }else{
            info.setFlag(true);
            info.setData(orders);
        }
        writeJsonValue(response, info);
    }
    public void getOrdersByUserId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        String userId = request.getParameter("uid");
        if(userId == null){
            info.setFlag(false);
            info.setErrorMsg("获取订单失败");
            writeJsonValue(response, info);
            return;
        }
        List<Order> orders = orderService.getOrdersByUserId(userId);
        //检查返回的订单是否为空
        if(orders == null){
            info.setFlag(false);
            info.setErrorMsg("获取订单失败");
        }else{
            info.setFlag(true);
            for(Order order : orders){
                order.setOrderItems(orderItemService.getOrderItemsByOrderId(order.getId()));
//                System.out.println(order);
            }
            info.setData(orders);
        }
//        System.out.println(info);
        writeJsonValue(response, info);
    }
    public void updateStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        int oid = Integer.parseInt(request.getParameter("id"));
        int status = Integer.parseInt(request.getParameter("status"));

        boolean flag = orderService.updateStatus(oid, status);
        if(flag){
            info.setFlag(true);
        }else{
            info.setFlag(false);
            info.setErrorMsg("更新订单失败");
        }
        writeJsonValue(response, info);
    }
    public void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        int oid = Integer.parseInt(request.getParameter("id"));
        boolean flag = orderService.deleteOrder(oid);
        if(flag){
            info.setFlag(true);
        }else{
            info.setFlag(false);
            info.setErrorMsg("删除订单失败");
        }
        writeJsonValue(response, info);
    }
}

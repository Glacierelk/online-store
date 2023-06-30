package com.hitwh.onlinestore.web.servlet;



import com.hitwh.onlinestore.bean.Order;
import com.hitwh.onlinestore.bean.ResultInfo;
import com.hitwh.onlinestore.service.OrderService;
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
}

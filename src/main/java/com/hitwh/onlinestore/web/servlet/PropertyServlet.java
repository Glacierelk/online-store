package com.hitwh.onlinestore.web.servlet;

import com.hitwh.onlinestore.bean.Product;
import com.hitwh.onlinestore.bean.ResultInfo;
import com.hitwh.onlinestore.service.PropertyService;
import com.hitwh.onlinestore.service.impl.PropertyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/property/*")
public class PropertyServlet extends BaseServlet {
    private final PropertyService propertyService = new PropertyServiceImpl();

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        try {
            int cid = Integer.parseInt(request.getParameter("cid"));
            String name = request.getParameter("name");
            if (propertyService.addProperty(cid, name)) {
                info.setFlag(true);
            } else {
                info.setFlag(false);
                info.setErrorMsg("添加失败");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            info.setFlag(false);
            info.setErrorMsg("添加失败, 请检查输入的数据类型");
        } catch (Exception e) {
            e.printStackTrace();
            info.setFlag(false);
            info.setErrorMsg("添加失败");
        }
        writeJsonValue(response, info);
    }


    /**
     * 改变属性值
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void change(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String value = request.getParameter("value");
            if (propertyService.changeProperty(id, value)) {
                info.setFlag(true);
            } else {
                info.setFlag(false);
                info.setErrorMsg("添加失败");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            info.setFlag(false);
            info.setErrorMsg("添加失败, 请检查输入的数据类型");
        } catch (Exception e) {
            e.printStackTrace();
            info.setFlag(false);
            info.setErrorMsg("添加失败");
        }
        writeJsonValue(response, info);
    }
}

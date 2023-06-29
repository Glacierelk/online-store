package com.hitwh.onlinestore.web.servlet;

import com.hitwh.onlinestore.bean.ResultInfo;
import com.hitwh.onlinestore.service.CategoryService;
import com.hitwh.onlinestore.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet{
    public final CategoryService categoryService = new CategoryServiceImpl();

    /*
     * 获取首页分类
     */
    public void homePageCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("homePageCategory");
        ResultInfo info = new ResultInfo();
        info.setData(categoryService.categoryAndProduct());
        if (info.getData() != null){
            info.setFlag(true);
        }else {
            info.setFlag(false);
            info.setErrorMsg("获取首页分类失败");
        }
        writeJsonValue(response, info);
    }

    /*
     * 后台获取所有分类
     */
    public void listAllCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("listAllCategories");
        ResultInfo info = new ResultInfo();
        info.setData(categoryService.listAllCategories());
        if (info.getData() != null) {
            info.setFlag(true);
        } else {
            info.setFlag(false);
            info.setErrorMsg("获取所有分类失败");
        }
        writeJsonValue(response, info);
    }
}

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
     * 删除商品分类
     */
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("delete");
        ResultInfo info = new ResultInfo();
        String categoryId = request.getParameter("categoryId");
        System.out.println(categoryId);
        if (categoryId == null || categoryId.length() == 0) {
            info.setFlag(false);
            info.setErrorMsg("删除商品分类失败");
        } else {
            if (categoryService.deleteCategory(Integer.parseInt(categoryId))) {
                info.setFlag(true);
            } else {
                info.setFlag(false);
                info.setErrorMsg("删除商品分类失败");
            }
        }
        writeJsonValue(response, info);
    }

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

    /*
     * 后台添加分类
     * @param 商品种类名称
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("addCategory");
        ResultInfo info = new ResultInfo();
        String categoryName = request.getParameter("categoryName");
        if (categoryName == null || categoryName.length() == 0) {
            info.setFlag(false);
            info.setErrorMsg("添加商品分类失败");
        } else {
            if (categoryService.addCategory(categoryName)) {
                info.setFlag(true);
            } else {
                info.setFlag(false);
                info.setErrorMsg("添加商品分类失败");
            }
        }
        writeJsonValue(response, info);
    }

    /*
     * 根据分类cid获取商品内容
     */
    public void searchCategoryProperty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("searchCategoryProperty");
        ResultInfo info = new ResultInfo();
        int cid = Integer.parseInt(request.getParameter("cid"));
        System.out.println(cid);
        info.setData(categoryService.cidCategoryProperty(cid));
        if (info.getData() != null){
            info.setFlag(true);
        }else {
            info.setFlag(false);
            info.setErrorMsg("根据分类cid获取商品内容失败");
        }
        writeJsonValue(response, info);
    }
}

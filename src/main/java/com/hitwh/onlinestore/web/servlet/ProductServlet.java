package com.hitwh.onlinestore.web.servlet;

import com.hitwh.onlinestore.bean.Product;
import com.hitwh.onlinestore.bean.ResultInfo;
import com.hitwh.onlinestore.service.ProductService;
import com.hitwh.onlinestore.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/*")
public class ProductServlet extends BaseServlet {
    private final ProductService productService = new ProductServiceImpl();

    /*
     * @Description: 添加商品
     * @Param request:产品名称、产品价格、产品库存、产品小标题、产品优惠价格、产品类型id
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ProductServlet--add");
        Product product = new Product();
        ResultInfo info = new ResultInfo();
        try {
            product.setName(request.getParameter("name"));
            product.setOriginalPrice(Double.parseDouble(request.getParameter("originalPrice")));
            product.setPromotePrice(Double.parseDouble(request.getParameter("promotePrice")));
            product.setStock(Integer.parseInt(request.getParameter("stock")));
            product.setSubTitle(request.getParameter("subTitle"));
            product.setCid(Integer.parseInt(request.getParameter("cid")));
            System.out.println(product);
            if (productService.addProduct(product)) {
                info.setFlag(true);
            } else {
                info.setFlag(false);
                info.setErrorMsg("添加失败");
            }
        } catch (NumberFormatException e) {
            info.setFlag(false);
            info.setErrorMsg("添加失败, 请检查输入的数据类型");
        } catch (Exception e) {
            info.setFlag(false);
            info.setErrorMsg("添加失败");
        }
        writeJsonValue(response, info);
    }

    /*
     * @Description: 删除商品
     * @Param request:产品id
     */
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ProductServlet--delete");
        ResultInfo info = new ResultInfo();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            if (productService.delete(id)) {
                info.setFlag(true);
            } else {
                info.setFlag(false);
                info.setErrorMsg("删除失败");
            }
        } catch (NumberFormatException e) {
            info.setFlag(false);
            info.setErrorMsg("删除失败, 请检查输入的数据类型");
        } catch (Exception e) {
            info.setFlag(false);
            info.setErrorMsg("删除失败");
        }
        writeJsonValue(response, info);
    }

    /*
     * @Description: 商品详情
     * @Param request:产品id
     */
    public void details(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ProductServlet--details");
        ResultInfo info = new ResultInfo();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            info.setData(productService.details(id));
            info.setFlag(true);
        } catch (NumberFormatException e) {
            info.setFlag(false);
            info.setErrorMsg("查询失败, 请检查输入的数据类型");
        } catch (Exception e) {
            info.setFlag(false);
            info.setErrorMsg("查询失败");
        }
        writeJsonValue(response, info);
    }

    /*
     * @Description: 搜索商品
     * @Param request: 产品名称
     */
    public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ProductServlet--search");
        ResultInfo info = new ResultInfo();
        try {
            String name = request.getParameter("name");
            info.setData(productService.search(name));
            info.setFlag(true);
        } catch (Exception e) {
            info.setFlag(false);
            info.setErrorMsg("查询失败");
        }
        writeJsonValue(response, info);
    }

    /*
     * @Description: 修改商品
     * @Param request:产品名称、产品价格、产品库存、产品小标题、产品优惠价格、产品类型id
     */
    public void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("editProduct");
        Product product = new Product();
        ResultInfo info = new ResultInfo();
        try {
            product.setId(Integer.parseInt(request.getParameter("id")));
            product.setName(request.getParameter("name"));
            product.setOriginalPrice(Double.parseDouble(request.getParameter("originalPrice")));
            product.setPromotePrice(Double.parseDouble(request.getParameter("promotePrice")));
            product.setStock(Integer.parseInt(request.getParameter("stock")));
            product.setSubTitle(request.getParameter("subTitle"));
            product.setCid(Integer.parseInt(request.getParameter("cid")));
            System.out.println(product);
            if (productService.changeProduct(product)) {
                info.setFlag(true);
            } else {
                info.setFlag(false);
                info.setErrorMsg("添加失败");
            }
        } catch (NumberFormatException e) {
            info.setFlag(false);
            info.setErrorMsg("添加失败, 请检查输入的数据类型");
        } catch (Exception e) {
            info.setFlag(false);
            info.setErrorMsg("添加失败");
        }
        writeJsonValue(response, info);
    }
}

package com.hitwh.onlinestore.dao;

import com.hitwh.onlinestore.bean.Product;

import java.util.List;

public interface ProductDAO {
    /*
     * 根据商品类型id获取商品
     * @param categoryId 商品类型id
     * @return 商品列表
     */
    List<Product> homePageGetProductsByCategoryId(int categoryId);

    /*
     * 新增商品
     */
    boolean addProduct(Product product);
}

package com.hitwh.onlinestore.dao;

import com.hitwh.onlinestore.bean.ProductProperties;
import com.hitwh.onlinestore.bean.Property;

import java.util.List;

public interface PropertyDAO {
    /*
     * 根据商品分类id获取商品属性
     */
    List<Property> getPropertyByCategoryId(Integer categoryId);

    /*
     * 根据商品id获取商品的所有属性
     */
    List<ProductProperties> getPropertiesByProductId(int id);
    /*
        * 添加商品属性
     */
    boolean addProperty(int cid,String name);
}

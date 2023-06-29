package com.hitwh.onlinestore.dao;

import com.hitwh.onlinestore.bean.Property;

import java.util.List;

public interface PropertyDAO {
    /*
     * 根据商品分类id获取商品属性
     */
    List<Property> getPropertyByCategoryId(Integer categoryId);
}

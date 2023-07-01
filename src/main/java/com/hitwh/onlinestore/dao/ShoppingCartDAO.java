package com.hitwh.onlinestore.dao;

import com.hitwh.onlinestore.bean.ShoppingCart;

import java.util.List;

public interface ShoppingCartDAO {
    /**
     * 根据用户ID返回当前用户购物车内容
     */
    List<ShoppingCart> queryByUserId(Integer userId);
}

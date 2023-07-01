package com.hitwh.onlinestore.service;

import com.hitwh.onlinestore.bean.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    /**
     * 根据用户 ID 获取购物车信息
     */
    List<ShoppingCart> getShoppingCartByUserId(Integer uid);
}

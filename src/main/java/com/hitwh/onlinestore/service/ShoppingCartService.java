package com.hitwh.onlinestore.service;

import com.hitwh.onlinestore.bean.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    /**
     * 根据用户 ID 获取购物车信息
     */
    List<ShoppingCart> getShoppingCartByUserId(Integer uid);
    boolean addGoods(ShoppingCart shoppingCart);
    boolean deleteGoods(int uid,int pid);
    boolean alterGoodNumber(ShoppingCart shoppingCart);

    /**
     * 获取购物车商品数量
     * @param id 用户 ID
     * @return integer
     */
    Integer getShoppingCartCount(int id);

    boolean checkCartStatus(int pid,int uid);
}

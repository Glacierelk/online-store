package com.hitwh.onlinestore.dao;

import com.hitwh.onlinestore.bean.ShoppingCart;

import java.util.List;

public interface ShoppingCartDAO {
    /**
     * 根据用户ID返回当前用户购物车内容
     */
    List<ShoppingCart> queryByUserId(Integer userId);
    /**
     * 添加商品到购物车
     */
    boolean addGoods(ShoppingCart shoppingCart);
    /**
     * 从购物车删除商品
     */
    boolean deleteGoods(int id);
    /**
     * 更改购物车中商品的数量
     */
    boolean alterGoodsNumber(int id,int count);
    /**
     * 根据用户ID查询购物车商品数量
     * @param id 用户ID
     * @return integer 商品数量
     */
    Integer getCount(int id);
    /**
     * 检查商品是否被加入到购物车中
     */
    boolean getCartStatus(int pid,int uid);
}

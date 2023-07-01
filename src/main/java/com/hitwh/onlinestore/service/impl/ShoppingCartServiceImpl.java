package com.hitwh.onlinestore.service.impl;

import com.hitwh.onlinestore.bean.ShoppingCart;
import com.hitwh.onlinestore.dao.ShoppingCartDAO;
import com.hitwh.onlinestore.dao.impl.ShoppingCartDAOImpl;
import com.hitwh.onlinestore.service.ShoppingCartService;

import java.util.List;

public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAOImpl();

    @Override
    public List<ShoppingCart> getShoppingCartByUserId(Integer uid) {
        return shoppingCartDAO.queryByUserId(uid);
    }
}

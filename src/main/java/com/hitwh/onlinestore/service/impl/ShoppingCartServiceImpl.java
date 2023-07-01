package com.hitwh.onlinestore.service.impl;

import com.hitwh.onlinestore.bean.ShoppingCart;
import com.hitwh.onlinestore.dao.ProductDAO;
import com.hitwh.onlinestore.dao.ShoppingCartDAO;
import com.hitwh.onlinestore.dao.impl.ProductDAOImpl;
import com.hitwh.onlinestore.dao.impl.ShoppingCartDAOImpl;
import com.hitwh.onlinestore.service.ShoppingCartService;

import java.util.List;

public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAOImpl();
    private final ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public List<ShoppingCart> getShoppingCartByUserId(Integer uid) {
        List<ShoppingCart> shoppingCarts = shoppingCartDAO.queryByUserId(uid);
        shoppingCarts.forEach(cart -> {
            cart.setProduct(productDAO.queryById(cart.getPid()));
            cart.setImageId(productDAO.getImageByProductId(cart.getPid()).getId());
        });
        return shoppingCarts;
    }

    @Override
    public Integer getShoppingCartCount(int id) {
        return shoppingCartDAO.getCount(id);
    }
}

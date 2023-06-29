package com.hitwh.onlinestore.service.impl;

import com.hitwh.onlinestore.bean.Product;
import com.hitwh.onlinestore.dao.ProductDAO;
import com.hitwh.onlinestore.dao.impl.ProductDAOImpl;
import com.hitwh.onlinestore.service.ProductService;

import java.sql.Timestamp;
import java.time.Instant;

public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public boolean addProduct(Product product) {
        System.out.println("ProductServiceImpl--addProduct");
        product.setCreateDate(new Timestamp(System.currentTimeMillis()));
        return productDAO.addProduct(product);
    }
}

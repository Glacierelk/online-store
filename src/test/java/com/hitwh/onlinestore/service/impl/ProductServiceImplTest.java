package com.hitwh.onlinestore.service.impl;

import com.hitwh.onlinestore.bean.Product;
import com.hitwh.onlinestore.dao.ProductDAO;
import com.hitwh.onlinestore.dao.impl.ProductDAOImpl;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {
    private final ProductDAO productDAO = new ProductDAOImpl();

    @Test
    void addProduct() {
        Product product = new Product();
        product.setName("test");
        product.setSubTitle("test");
        product.setOriginalPrice(1.0);
        product.setPromotePrice(1.0);
        product.setStock(1);
        product.setCid(71);
        product.setCreateDate(new Timestamp(System.currentTimeMillis()));
        assertTrue(productDAO.addProduct(product));
    }
}
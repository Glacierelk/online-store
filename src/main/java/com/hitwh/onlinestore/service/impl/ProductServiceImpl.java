package com.hitwh.onlinestore.service.impl;

import com.hitwh.onlinestore.bean.Product;
import com.hitwh.onlinestore.bean.ProductDetails;
import com.hitwh.onlinestore.dao.CommentDAO;
import com.hitwh.onlinestore.dao.ProductDAO;
import com.hitwh.onlinestore.dao.PropertyDAO;
import com.hitwh.onlinestore.dao.impl.CommentDAOImpl;
import com.hitwh.onlinestore.dao.impl.ProductDAOImpl;
import com.hitwh.onlinestore.dao.impl.PropertyDAOImpl;
import com.hitwh.onlinestore.service.ProductService;

import java.sql.Timestamp;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO = new ProductDAOImpl();
    private final PropertyDAO propertyDAO = new PropertyDAOImpl();
    private final CommentDAO commentDAO = new CommentDAOImpl();

    @Override
    public boolean addProduct(Product product) {
        System.out.println("ProductServiceImpl--addProduct");
        product.setCreateDate(new Timestamp(System.currentTimeMillis()));
        return productDAO.addProduct(product);
    }

    @Override
    public boolean delete(int id) {
        System.out.println("ProductServiceImpl--delete");
        return productDAO.delete(id);
    }

    @Override
    public Object details(int id) {
        ProductDetails product = productDAO.queryById(id);
        if (product == null) {
            return null;
        }
        product.setImages(productDAO.getImagesByProductId(id));
        product.setProperties(propertyDAO.getPropertiesByProductId(id));
        product.setComments(commentDAO.getCommentsByProductId(id));
        return product;
    }

    @Override
    public Object search(String name) {
        List<ProductDetails> products = productDAO.queryByName(name);
        if (products == null) {
            return null;
        }
        products.forEach(product -> product.setImages(productDAO.getImagesByProductId(product.getId())));
        return products;
    }
}

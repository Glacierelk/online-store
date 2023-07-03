package com.hitwh.onlinestore.service.impl;

import com.hitwh.onlinestore.bean.Category;
import com.hitwh.onlinestore.bean.Product;
import com.hitwh.onlinestore.bean.ProductDetails;
import com.hitwh.onlinestore.dao.CategoryDAO;
import com.hitwh.onlinestore.dao.ProductDAO;
import com.hitwh.onlinestore.dao.impl.CategoryDAOImpl;
import com.hitwh.onlinestore.dao.impl.ProductDAOImpl;
import com.hitwh.onlinestore.service.CategoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryDAO categoryDAO = new CategoryDAOImpl();
    private final ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public Object categoryAndProduct() {
        List<Category> categories = categoryDAO.listAllCategories();
        List<Object> categoryAndProduct = new ArrayList<>();
        for (Category category : categories) {
            Map<String, Object> categoryMap = new HashMap<>();
            categoryMap.put("cid", category.getId());
            categoryMap.put("category_name", category.getName());
            categoryMap.put("category_image", category.getUrlPath());
            List<ProductDetails> products = productDAO.homePageGetProductsByCategoryId(category.getId());
            products.forEach(product -> product.setImages(productDAO.getImagesByProductId(product.getId())));
            categoryMap.put("products", products);
            categoryAndProduct.add(categoryMap);
        }
        return categoryAndProduct;
    }


    @Override
    public Object listAllCategories() {
        return categoryDAO.listAllCategories();
    }

    @Override
    public boolean deleteCategory(int i) {
        return categoryDAO.deleteCategory(i);
    }

    @Override
    public boolean addCategory(String categoryName) {
        return categoryDAO.addCategory(categoryName);
    }

    @Override
    public Object cidCategoryProperty(int i) {
        System.out.println(i);
        return categoryDAO.getPropertyByCid(i);}
}

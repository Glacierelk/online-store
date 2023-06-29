package com.hitwh.onlinestore.service.impl;

import com.hitwh.onlinestore.bean.Category;
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
            categoryMap.put("products", productDAO.homePageGetProductsByCategoryId(category.getId()));
            categoryAndProduct.add(categoryMap);
        }
        return categoryAndProduct;
    }

    @Override
    public Object listAllCategories() {
        return categoryDAO.listAllCategories();
    }
}

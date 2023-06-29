package com.hitwh.onlinestore.service.impl;

import com.hitwh.onlinestore.bean.Category;
import com.hitwh.onlinestore.dao.CategoryDAO;
import com.hitwh.onlinestore.dao.ProductDAO;
import com.hitwh.onlinestore.dao.impl.CategoryDAOImpl;
import com.hitwh.onlinestore.dao.impl.ProductDAOImpl;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceImplTest {
    private final CategoryDAO categoryDAO = new CategoryDAOImpl();
    private final ProductDAO productDAO = new ProductDAOImpl();

    @Test
    void categoryAndProduct() {
        List<Category> categories = categoryDAO.listAllCategories();
        Map<String, Map<String, Object>> categoryAndProduct = new HashMap<>();
        for (Category category : categories) {
            Map<String, Object> categoryMap = new HashMap<>();
            categoryMap.put("cid", category.getId());
            categoryMap.put("products", productDAO.homePageGetProductsByCategoryId(category.getId()));
            categoryAndProduct.put(category.getName(), categoryMap);
        }
        System.out.println(categoryAndProduct);
    }

    @Test
    void listAllCategories() {
    }

    @Test
    void deleteCategory() {
        System.out.println(categoryDAO.deleteCategory(84));
    }

    @Test
    void addCategory() {
        System.out.println(categoryDAO.addCategory("test"));
    }
}
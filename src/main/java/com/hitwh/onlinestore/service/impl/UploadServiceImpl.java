package com.hitwh.onlinestore.service.impl;

import com.hitwh.onlinestore.dao.CategoryDAO;
import com.hitwh.onlinestore.dao.ProductDAO;
import com.hitwh.onlinestore.dao.UploadDAO;
import com.hitwh.onlinestore.dao.impl.CategoryDAOImpl;
import com.hitwh.onlinestore.dao.impl.ProductDAOImpl;
import com.hitwh.onlinestore.dao.impl.UploadDAOImpl;
import com.hitwh.onlinestore.service.UploadService;

import java.io.InputStream;

public class UploadServiceImpl implements UploadService {
    private final UploadDAO uploadDAO = new UploadDAOImpl();
    private final ProductDAO productDAO = new ProductDAOImpl();
    private final CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    public boolean uploadImage(String imageName, InputStream inputStream, String type, Integer id) {
        String url = uploadDAO.uploadImage(imageName, inputStream, type);
        if (url != null) {
            if (type.equals("category"))
                return categoryDAO.addImageByCategoryId(id, url);
            else
                return productDAO.addImageByProductId(id, type, url);
        } else {
            return false;
        }
    }
}

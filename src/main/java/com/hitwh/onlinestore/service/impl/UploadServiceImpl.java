package com.hitwh.onlinestore.service.impl;

import com.hitwh.onlinestore.dao.ProductDAO;
import com.hitwh.onlinestore.dao.UploadDAO;
import com.hitwh.onlinestore.dao.impl.ProductDAOImpl;
import com.hitwh.onlinestore.dao.impl.UploadDAOImpl;
import com.hitwh.onlinestore.service.UploadService;

import java.io.InputStream;

public class UploadServiceImpl implements UploadService {
    private final UploadDAO uploadDAO = new UploadDAOImpl();
    private final ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public boolean uploadImage(String imageName, InputStream inputStream) {
        String url = uploadDAO.uploadImage(imageName, inputStream);
        if (url != null) {
            return productDAO.addImageByProductId(999, "type_single", url);
        } else {
            return false;
        }
    }
}

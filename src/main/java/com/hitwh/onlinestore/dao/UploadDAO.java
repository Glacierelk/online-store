package com.hitwh.onlinestore.dao;

import java.io.InputStream;

public interface UploadDAO {
    /**
     * 上传图片
     */
    public String uploadImage(String imageName, InputStream input);
}

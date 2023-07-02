package com.hitwh.onlinestore.service;

import java.io.InputStream;

public interface UploadService {
    /**
     * 上传图片
     */
    boolean uploadImage(String imageName, InputStream inputStream, String type, Integer pid);
}

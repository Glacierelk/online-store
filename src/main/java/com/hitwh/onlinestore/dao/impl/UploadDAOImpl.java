package com.hitwh.onlinestore.dao.impl;

import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.hitwh.onlinestore.dao.UploadDAO;

import java.io.InputStream;

public class UploadDAOImpl implements UploadDAO {
    String endpoint = "oss-cn-beijing.aliyuncs.com";
    // RAM用户的访问密钥（AccessKey ID和AccessKey Secret）。
    String accessKeyId = "yourAccessKeyId";
    String accessKeySecret = "yourAccessKeySecret";
    // 使用代码嵌入的RAM用户的访问密钥配置访问凭证。
    CredentialsProvider credentialsProvider = new DefaultCredentialProvider(accessKeyId, accessKeySecret);

    @Override
    public String uploadImage(String fileName, InputStream input) {
        return null;
    }
}

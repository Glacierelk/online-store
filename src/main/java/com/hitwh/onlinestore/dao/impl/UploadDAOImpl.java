package com.hitwh.onlinestore.dao.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.hitwh.onlinestore.dao.UploadDAO;

import java.io.FileInputStream;
import java.io.InputStream;

public class UploadDAOImpl implements UploadDAO {
    private final String endpoint = "oss-cn-beijing.aliyuncs.com";
    // RAM用户的访问密钥（AccessKey ID和AccessKey Secret）。
    private final String accessKeyId = "LTAI5tL1ZRoXNZY6VcxRyetX";
    private final String accessKeySecret = "TGXnJdiXeYrcFtbZgkms0jq0Ev71m1";
    // 使用代码嵌入的RAM用户的访问密钥配置访问凭证。
    private final CredentialsProvider credentialsProvider = new DefaultCredentialProvider(accessKeyId, accessKeySecret);
    private final String bucketName = "online-store-wenruyv";
    private final OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);

    @Override
    public String uploadImage(String imageName, InputStream input) {
        try {
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, imageName, input);
            // 创建PutObject请求。
            PutObjectResult result = ossClient.putObject(putObjectRequest);
            return "https://" + bucketName + "." + endpoint + "/" + imageName;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return null;
    }
}

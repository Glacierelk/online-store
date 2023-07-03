package com.hitwh.onlinestore.web.servlet;

import com.hitwh.onlinestore.bean.ResultInfo;
import com.hitwh.onlinestore.service.UploadService;
import com.hitwh.onlinestore.service.impl.UploadServiceImpl;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import java.util.UUID;

@WebServlet("/upload/*")
@MultipartConfig
public class ImageUploadServlet extends BaseServlet {
    private final UploadService uploadService = new UploadServiceImpl();

    public void product(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("product");
        ResultInfo info = new ResultInfo();
        try {
            Part part = request.getPart("file");
            String fileName = request.getParameter("filename");
            fileName = generateUniqueFileName(fileName);
            InputStream input = part.getInputStream();
            info.setFlag(uploadService.uploadImage(fileName, input,
                    request.getParameter("type"), Integer.valueOf(request.getParameter("pid"))));
            System.out.println(fileName);
        } catch (NumberFormatException e) {
            info.setFlag(false);
            info.setErrorMsg("请输入正确的商品id");
        } catch (Exception e) {
            info.setFlag(false);
            info.setErrorMsg("上传失败");
            e.printStackTrace();
        } finally {
            writeJsonValue(response, info);
        }
    }

    public void category(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("category");
        ResultInfo info = new ResultInfo();
        try {
            Part part = request.getPart("file");
            String fileName = request.getParameter("filename");
            fileName = generateUniqueFileName(fileName);
            InputStream input = part.getInputStream();
            info.setFlag(uploadService.uploadImage(fileName, input,
                    "category", Integer.valueOf(request.getParameter("id"))));
            System.out.println(fileName);
        } catch (NumberFormatException e) {
            info.setFlag(false);
            info.setErrorMsg("请输入正确的商品分类id");
        } catch (Exception e) {
            info.setFlag(false);
            info.setErrorMsg("上传失败");
            e.printStackTrace();
        } finally {
            writeJsonValue(response, info);
        }
    }

    private String generateUniqueFileName(String originalFileName) {
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        return UUID.randomUUID().toString() + extension;
    }
}

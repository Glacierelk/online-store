package com.hitwh.onlinestore.web.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

@WebServlet("/upload/*")
public class ImageUploadServlet extends BaseServlet {
    public void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test");
        try {
            Part part = request.getPart("image");
            String fileName = generateUniqueFileName(part);
            InputStream input = part.getInputStream();
            OutputStream output = response.getOutputStream();
            IOUtils.copy(input, output);
        } catch (Exception e) {
            response.getWriter().print("图片上传失败：" + e.getMessage());
        }
    }

    private String generateUniqueFileName(Part part) {
        String originalFileName = part.getSubmittedFileName();
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        return UUID.randomUUID().toString() + extension;
    }
}

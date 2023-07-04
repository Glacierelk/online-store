package com.hitwh.onlinestore.service.impl;

import com.hitwh.onlinestore.dao.CategoryDAO;
import com.hitwh.onlinestore.dao.ProductDAO;
import com.hitwh.onlinestore.dao.UploadDAO;
import com.hitwh.onlinestore.dao.impl.CategoryDAOImpl;
import com.hitwh.onlinestore.dao.impl.ProductDAOImpl;
import com.hitwh.onlinestore.dao.impl.UploadDAOImpl;
import com.hitwh.onlinestore.service.UploadService;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class UploadServiceImpl implements UploadService {
    private final ProductDAO productDAO = new ProductDAOImpl();
    private final CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    public boolean uploadImage(String imageName, InputStream inputStream, String type, Integer id) {
        imageName = generateUniqueFileName(imageName);
        try {
            UploadDAO uploadDAO = new UploadDAOImpl();
//            System.out.println(url + "   uploadImage");
            if (type.equals("category")) {
                String url = uploadDAO.uploadImage(imageName, inputStream, type);
                return categoryDAO.addImageByCategoryId(id, url);
            } else {
                String url = uploadDAO.uploadImage(imageName, inputStream, type);
                String middle = "";
                String small = "";
                if (type.equals("type_single")) {
                    middle = uploadDAO.uploadImage(imageName,
                            resizeImage(inputStream, 217), "type_single_middle");
                    small = uploadDAO.uploadImage(imageName,
                            resizeImage(inputStream, 56), "type_single_small");
                    System.out.println(middle);
                    System.out.println(small);
                }
                return productDAO.addImageByProductId(id, type, url, middle, small);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private InputStream resizeImage(InputStream inputStream, int newWidth) throws IOException {
        System.out.println("resizeImage" + inputStream);
        BufferedImage inputImage = ImageIO.read(inputStream);
        System.out.println(inputImage);

        int currentWidth = inputImage.getWidth();
        int currentHeight = inputImage.getHeight();
        int newHeight = (int) Math.round((double) currentHeight / currentWidth * newWidth);

        //create new image
        Image newImage = inputImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage outputImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

        //draw new image
        Graphics2D graphics2D = outputImage.createGraphics();
        graphics2D.drawImage(newImage, 0, 0, null);
        graphics2D.dispose();

        //convert buffered image to input stream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(outputImage, "jpg", outputStream);
        return new ByteArrayInputStream(outputStream.toByteArray());
    }

    private String generateUniqueFileName(String originalFileName) {
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        return UUID.randomUUID().toString() + extension;
    }
}

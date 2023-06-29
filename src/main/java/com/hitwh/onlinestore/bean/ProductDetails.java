package com.hitwh.onlinestore.bean;

import java.sql.Timestamp;
import java.util.List;

public class ProductDetails extends Product {
    private List<ProductImage> images;
    private List<ProductProperties> properties;
    private List<Comment> comments;

    public ProductDetails() {
    }

    public ProductDetails(List<ProductImage> images, List<ProductProperties> properties, List<Comment> comments) {
        this.images = images;
        this.properties = properties;
        this.comments = comments;
    }

    public ProductDetails(int id, String name, String subTitle, Double originalPrice, Double promotePrice, int stock, int cid, Timestamp createDate, List<ProductImage> images, List<ProductProperties> properties, List<Comment> comments) {
        super(id, name, subTitle, originalPrice, promotePrice, stock, cid, createDate);
        this.images = images;
        this.properties = properties;
        this.comments = comments;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }

    public List<ProductProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<ProductProperties> properties) {
        this.properties = properties;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "images=" + images +
                ", properties=" + properties +
                ", comments=" + comments +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", originalPrice=" + originalPrice +
                ", promotePrice=" + promotePrice +
                ", stock=" + stock +
                ", cid=" + cid +
                ", createDate=" + createDate +
                '}';
    }
}

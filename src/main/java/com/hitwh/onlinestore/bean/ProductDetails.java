package com.hitwh.onlinestore.bean;

import java.sql.Timestamp;
import java.util.List;

public class ProductDetails extends Product {
    private List<ProductImage> images;
    private List<ProductProperties> properties;
    private List<Comment> comments;
    private Category category;

    public ProductDetails() {
    }

    public ProductDetails(Product product) {
        this.setId(product.getId());
        this.setName(product.getName());
        this.setOriginalPrice(product.getOriginalPrice());
        this.setPromotePrice(product.getPromotePrice());
        this.setStock(product.getStock());
        this.setSubTitle(product.getSubTitle());
        this.setCid(product.getCid());
        this.setCreateDate(product.getCreateDate());
    }

    public ProductDetails(Product product, List<ProductImage> images, List<ProductProperties> properties, List<Comment> comments, Category category) {
        this.setId(product.getId());
        this.setName(product.getName());
        this.setOriginalPrice(product.getOriginalPrice());
        this.setPromotePrice(product.getPromotePrice());
        this.setStock(product.getStock());
        this.setSubTitle(product.getSubTitle());
        this.setCid(product.getCid());
        this.setCreateDate(product.getCreateDate());
        this.images = images;
        this.properties = properties;
        this.comments = comments;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "images=" + images +
                ", properties=" + properties +
                ", comments=" + comments +
                ", category=" + category +
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

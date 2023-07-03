package com.hitwh.onlinestore.bean;

public class ShoppingCart {
    private Integer id;
    private Integer pid; // 商品id
    private Integer uid; // 用户id
    private Integer count; // 商品数量
    private Integer status; // 商品状态
    private Product product; // 商品信息
    private ProductImage image; // 商品图片

    public ShoppingCart() {
    }

    public ShoppingCart(Integer pid, Integer uid, Integer count, Integer status) {
        this.pid = pid;
        this.uid = uid;
        this.count = count;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductImage getImage() {
        return image;
    }

    public void setImage(ProductImage image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", pid=" + pid +
                ", uid=" + uid +
                ", count=" + count +
                ", status=" + status +
                ", product=" + product +
                ", image=" + image +
                '}';
    }
}

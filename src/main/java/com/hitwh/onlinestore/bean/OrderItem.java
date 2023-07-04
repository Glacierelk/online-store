package com.hitwh.onlinestore.bean;

public class OrderItem {
    private int id;
    private int pid;
    private int oid;
    private String name;
    private Double originalPrice;
    private Double promotePrice;
    private int count;
    private ProductImage productImage;





    public OrderItem() {
    }

    public OrderItem(int id, int pid, int oid, String name, Double originalPrice, Double promotePrice, int count, ProductImage productImage) {
        this.id = id;
        this.pid = pid;
        this.oid = oid;
        this.name = name;
        this.originalPrice = originalPrice;
        this.promotePrice = promotePrice;
        this.count = count;
        this.productImage = productImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(Double promotePrice) {
        this.promotePrice = promotePrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ProductImage getProductImage() {
        return productImage;
    }

    public void setProductImage(ProductImage productImage) {
        this.productImage = productImage;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", pid=" + pid +
                ", oid=" + oid +
                ", name='" + name + '\'' +
                ", originalPrice=" + originalPrice +
                ", promotePrice=" + promotePrice +
                ", count=" + count +
                ", productImage=" + productImage +
                '}';
    }








}

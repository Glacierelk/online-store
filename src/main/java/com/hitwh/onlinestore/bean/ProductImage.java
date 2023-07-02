package com.hitwh.onlinestore.bean;

public class ProductImage {
    private int id;
    private int pid;
    private String type;
    private String urlPath;

    public ProductImage() {
    }

    public ProductImage(int id, int pid, String type, String urlPath) {
        this.id = id;
        this.pid = pid;
        this.type = type;
        this.urlPath = urlPath;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                ", pid=" + pid +
                ", type='" + type + '\'' +
                ", urlPath='" + urlPath + '\'' +
                '}';
    }
}

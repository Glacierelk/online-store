package com.hitwh.onlinestore.bean;

public class ProductImage {
    private int id;
    private int pid;
    private String type;
    private String urlPath;
    private String singleMiddle;
    private String singleSmall;

    public ProductImage() {
    }

    public ProductImage(int id, int pid, String type, String urlPath, String singleMiddle, String singleSmall) {
        this.id = id;
        this.pid = pid;
        this.type = type;
        this.urlPath = urlPath;
        this.singleMiddle = singleMiddle;
        this.singleSmall = singleSmall;
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

    public String getSingleMiddle() {
        return singleMiddle;
    }

    public void setSingleMiddle(String singleMiddle) {
        this.singleMiddle = singleMiddle;
    }

    public String getSingleSmall() {
        return singleSmall;
    }

    public void setSingleSmall(String singleSmall) {
        this.singleSmall = singleSmall;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                ", pid=" + pid +
                ", type='" + type + '\'' +
                ", urlPath='" + urlPath + '\'' +
                ", singleMiddle='" + singleMiddle + '\'' +
                ", singleSmall='" + singleSmall + '\'' +
                '}';
    }
}

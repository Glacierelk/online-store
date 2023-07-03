package com.hitwh.onlinestore.bean;

public class Category {
    private int id;
    private String name;
    private String urlPath;

    public Category() {
    }

    public Category(int id, String name, String urlPath) {
        this.id = id;
        this.name = name;
        this.urlPath = urlPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", urlPath='" + urlPath + '\'' +
                '}';
    }
}

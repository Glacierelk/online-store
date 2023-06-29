package com.hitwh.onlinestore.bean;

public class ProductProperties {
    private int id;
    private int pid;
    private String propertyName;
    private String propertyValue;

    public ProductProperties() {
    }

    public ProductProperties(int id, int pid, String propertyName, String propertyValue) {
        this.id = id;
        this.pid = pid;
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
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

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    @Override
    public String toString() {
        return "ProductProperties{" +
                "id=" + id +
                ", pid=" + pid +
                ", propertyName='" + propertyName + '\'' +
                ", propertyValue='" + propertyValue + '\'' +
                '}';
    }
}

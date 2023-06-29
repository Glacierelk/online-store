package com.hitwh.onlinestore.bean;

public class ProductProperties {
    private int id;
    private int pid;
    private String name;
    private String value;

    public ProductProperties() {
    }

    public ProductProperties(int id, int pid, String name, String value) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.value = value;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ProductProperties{" +
                "id=" + id +
                ", pid=" + pid +
                ", propertyName='" + name + '\'' +
                ", propertyValue='" + value + '\'' +
                '}';
    }
}

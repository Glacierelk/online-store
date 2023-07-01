package com.hitwh.onlinestore.bean;

public class OrderItem {
    private int id;
    private int pid;
    private int oid;
    private String name;
    private Double originalPrice;
    private Double promotePrice;
    private int number;

    public OrderItem() {
    }

    public OrderItem(int id, int pid, int oid, int number) {
        this.id = id;
        this.pid = pid;
        this.oid = oid;
        this.number = number;
    }

    public OrderItem(int id, int pid, int oid, String name, Double originalPrice, Double promotePrice, int number) {
        this.id = id;
        this.pid = pid;
        this.oid = oid;
        this.name = name;
        this.originalPrice = originalPrice;
        this.promotePrice = promotePrice;
        this.number = number;
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
                ", number=" + number +
                '}';
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

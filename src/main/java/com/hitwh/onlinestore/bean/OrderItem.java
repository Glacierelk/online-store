package com.hitwh.onlinestore.bean;

public class OrderItem {
    private int id;
    private int pid;
    private int oid;
    private int number;

    public OrderItem() {
    }

    public OrderItem(int id, int pid, int oid, int number) {
        this.id = id;
        this.pid = pid;
        this.oid = oid;
        this.number = number;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", pid=" + pid +
                ", oid=" + oid +
                ", number=" + number +
                '}';
    }
}

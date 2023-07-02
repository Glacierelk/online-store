package com.hitwh.onlinestore.service;

public interface PropertyService {
    /*
       添加商品属性，注意外键约束，cid必须是category表中的id
     */
    boolean addProperty(int cid,String name);

    boolean changeProperty(int id, String value);
}

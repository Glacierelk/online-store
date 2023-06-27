package com.hitwh.onlinestore.dao;

import com.hitwh.onlinestore.pojo.User;

import java.util.List;

public interface UserDAO {
    /*
    * 添加用户
     */
    void addUser(User user);
    User getUserByName(String name);
    User getUserById(int id);
    User getUserByNameAndPassword(String name, String password);
    boolean deleteUserByName(String name);
    int getTotal();
    List<User> getUserList(int start,int count);
}

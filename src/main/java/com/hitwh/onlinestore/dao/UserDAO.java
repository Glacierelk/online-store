package com.hitwh.onlinestore.dao;

import com.hitwh.onlinestore.bean.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);
    User getUserByName(String name);
    User getUserById(int id);
    User getUserByNameAndPassword(String name, String password);
    boolean deleteUserByName(String name);
    int getTotal();
    List<User> getUserList();
}

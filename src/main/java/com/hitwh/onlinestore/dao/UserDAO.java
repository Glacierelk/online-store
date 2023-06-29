package com.hitwh.onlinestore.dao;

import com.hitwh.onlinestore.bean.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);
    User getUserByUsername(String username);
    User getUserById(int id);
    User getUserByUsernameAndPassword(String username, String password);
    boolean deleteUserByUsername(String username);
    int getTotal();
    List<User> getUserList();
}

package com.hitwh.onlinestore.service;

import com.hitwh.onlinestore.bean.User;

import java.util.List;

public interface UserService {
    User login(String username, String password);
    boolean register(User user);
    List<User> getUserList();
    boolean deleteUser(int id);
}

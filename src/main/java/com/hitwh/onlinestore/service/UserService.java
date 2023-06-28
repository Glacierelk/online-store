package com.hitwh.onlinestore.service;

import com.hitwh.onlinestore.bean.User;

public interface UserService {
    User login(String username, String password);
    boolean register(User user);
}
